/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginapplication;

/**
 *
 * @author Student
 */



public class LoginSystem {
    String userName;
    String password;
    String cellPhoneNumber;
    
    private String registeredUserName;
    private String registeredPassword;
    private String registeredFirstName;
    private String registeredLastName;

    public LoginSystem(String userName, String password, String cellPhoneNumber) {
        this.userName = userName;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // ===== USERNAME =====
    public boolean checkUserName() {
        return userName != null && userName.length() <= 5 && userName.contains("_");
    }

    public String getUserNameMessage() {
        if (checkUserName()) {
            return "Username successfully captured.";
        }
        return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
    }

    // ===== PASSWORD =====
    public boolean checkPasswordComplexity() {
        return password != null
            && password.length() >= 8
            && password.matches(".*[A-Z].*")
            && password.matches(".*[0-9].*")
            && password.matches(".*[^a-zA-Z0-9].*");
    }

    public String getPasswordMessage() {
        if (checkPasswordComplexity()) {
            return "Password successfully captured.";
        }
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }

    // ===== CELL PHONE — Matches rubric message format =====
    public boolean checkCellPhoneNumber() {
        // Accepts: +27 followed by exactly 9 digits
        return cellPhoneNumber != null && cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    public String getCellMessage() {
        if (checkCellPhoneNumber()) {
            return "Cell phone number successfully added.";
        }
        return "Cell phone number incorrectly formatted or does not contain international code.";
    }

    // ===== REGISTER =====
    public String registerUser(String username, String password, String cellPhone, 
                               String firstName, String lastName) {
        this.userName = username;
        this.password = password;
        this.cellPhoneNumber = cellPhone;
        
        if (!checkUserName()) return getUserNameMessage();
        if (!checkPasswordComplexity()) return getPasswordMessage();
        if (!checkCellPhoneNumber()) return getCellMessage();
        
        registeredUserName = username;
        registeredPassword = password;
        registeredFirstName = firstName;
        registeredLastName = lastName;
        return "Registration successful.";
    }

    // ===== LOGIN =====
    public boolean checkUsernameMatch(String entered) {
        return entered != null && entered.equals(registeredUserName);
    }

    public boolean checkPasswordMatch(String entered) {
        return entered != null && entered.equals(registeredPassword);
    }

    public boolean loginUser(String username, String password) {
        return checkUsernameMatch(username) && checkPasswordMatch(password);
    }

    public String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome " + registeredFirstName + " " + registeredLastName + ", it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}