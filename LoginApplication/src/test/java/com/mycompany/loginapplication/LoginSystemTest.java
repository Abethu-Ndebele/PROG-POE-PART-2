/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.loginapplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */



public class LoginSystemTest {

    // ==================================
    // USERNAME TESTS — 5 Tests
    // ==================================
    @Test
    public void test01_UserName_ValidFormat() {
        LoginSystem auth = new LoginSystem("kyl_1", "", "");
        assertTrue(auth.checkUserName());
    }

    @Test
    public void test02_UserName_ValidSuccessMessage() {
        LoginSystem auth = new LoginSystem("j_doe", "", "");
        assertEquals("Username successfully captured.", auth.getUserNameMessage());
    }

    @Test
    public void test03_UserName_TooLong_Fails() {
        LoginSystem auth = new LoginSystem("kyle!!!!!!!", "", "");
        assertFalse(auth.checkUserName());
    }

    @Test
    public void test04_UserName_NoUnderscore_Fails() {
        LoginSystem auth = new LoginSystem("johndoe", "", "");
        assertFalse(auth.checkUserName());
    }

    @Test
    public void test05_UserName_ExactErrorMessage() {
        LoginSystem auth = new LoginSystem("kyle123", "", "");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
                     auth.getUserNameMessage());
    }

    // ==================================
    // PASSWORD TESTS — 5 Tests
    // ==================================
    @Test
    public void test06_Password_MeetsAllRequirements() {
        LoginSystem auth = new LoginSystem("", "Ch&&sec@ke99!", "");
        assertTrue(auth.checkPasswordComplexity());
    }

    @Test
    public void test07_Password_SuccessMessage() {
        LoginSystem auth = new LoginSystem("", "P@ssw0rd", "");
        assertEquals("Password successfully captured.", auth.getPasswordMessage());
    }

    @Test
    public void test08_Password_TooShort_Fails() {
        LoginSystem auth = new LoginSystem("", "Pass1@", "");
        assertFalse(auth.checkPasswordComplexity());
    }

    @Test
    public void test09_Password_MissingSpecialChar_Fails() {
        LoginSystem auth = new LoginSystem("", "Password1", "");
        assertFalse(auth.checkPasswordComplexity());
    }

    @Test
    public void test10_Password_ExactErrorMessage() {
        LoginSystem auth = new LoginSystem("", "password", "");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
                     auth.getPasswordMessage());
    }

    // ==================================
    // CELL PHONE TESTS — 4 Tests
    // ==================================
    @Test
    public void test11_CellPhone_Valid_SouthAfrican() {
        LoginSystem auth = new LoginSystem("", "", "+27838968976");
        assertTrue(auth.checkCellPhoneNumber());
    }

    @Test
    public void test12_CellPhone_SuccessMessage() {
        LoginSystem auth = new LoginSystem("", "", "+27718693002");
        assertEquals("Cell phone number successfully added.", auth.getCellMessage());
    }

    @Test
    public void test13_CellPhone_WrongCountryCode_Fails() {
        LoginSystem auth = new LoginSystem("", "", "+28838968976");
        assertFalse(auth.checkCellPhoneNumber());
    }

    @Test
    public void test14_CellPhone_NoPlusOrWrongFormat_Fails() {
        LoginSystem auth = new LoginSystem("", "", "0838968976");
        assertFalse(auth.checkCellPhoneNumber());
    }

    // ==================================
    // REGISTRATION TESTS — 3 Tests
    // ==================================
    @Test
    public void test15_Registration_AllValid_Succeeds() {
        LoginSystem auth = new LoginSystem("", "", "");
        String result = auth.registerUser("j_doe", "P@ssw0rd", "+27838968976", "John", "Doe");
        assertEquals("Registration successful.", result);
    }

    @Test
    public void test16_Registration_InvalidUsername_Fails() {
        LoginSystem auth = new LoginSystem("", "", "");
        String result = auth.registerUser("johndoe123", "P@ssw0rd", "+27838968976", "John", "Doe");
        assertTrue(result.contains("not correctly formatted"));
    }

    @Test
    public void test17_Registration_InvalidCell_Fails() {
        LoginSystem auth = new LoginSystem("", "", "");
        String result = auth.registerUser("j_doe", "P@ssw0rd", "0838968976", "John", "Doe");
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", result);
    }

    // ==================================
    // LOGIN TESTS — 3 Tests
    // ==================================
    @Test
    public void test18_Login_CorrectCredentials_Succeeds() {
        LoginSystem auth = new LoginSystem("", "", "");
        auth.registerUser("j_doe", "P@ssw0rd", "+27838968976", "John", "Doe");
        assertTrue(auth.loginUser("j_doe", "P@ssw0rd"));
    }

    @Test
    public void test19_Login_WrongUser_Fails() {
        LoginSystem auth = new LoginSystem("", "", "");
        auth.registerUser("j_doe", "P@ssw0rd", "+27838968976", "John", "Doe");
        assertFalse(auth.loginUser("wrong_user", "P@ssw0rd"));
        assertEquals("Username or password incorrect, please try again.", auth.returnLoginStatus(false));
    }

    @Test
    public void test20_Login_WrongPassword_Fails() {
        LoginSystem auth = new LoginSystem("", "", "");
        auth.registerUser("j_doe", "P@ssw0rd", "+27838968976", "John", "Doe");
        assertFalse(auth.loginUser("j_doe", "WrongPass"));
        assertEquals("Username or password incorrect, please try again.", auth.returnLoginStatus(false));
    }
}