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



public class MessageTest {

    // ===== Message Length Tests =====
    @Test
    public void test01_MessageLength_Valid() {
        Message m = new Message();
        assertEquals("Message ready to send.", 
            m.validateMessageLength("Hi Mike, can you join us for dinner tonight?"));
    }

    @Test
    public void test02_MessageLength_Exact250() {
        Message m = new Message();
        assertEquals("Message ready to send.", m.validateMessageLength("a".repeat(250)));
    }

    @Test
    public void test03_MessageLength_OverBy10() {
        Message m = new Message();
        assertEquals("Message exceeds 250 characters by 10; please reduce the size.", 
            m.validateMessageLength("a".repeat(260)));
    }

    @Test
    public void test04_MessageLength_OverBy50() {
        Message m = new Message();
        assertEquals("Message exceeds 250 characters by 50; please reduce the size.", 
            m.validateMessageLength("a".repeat(300)));
    }

    // ===== Recipient Cell Tests =====
    @Test
    public void test05_RecipientCell_Valid() {
        Message m = new Message();
        assertEquals("Cell phone number successfully captured.", 
            m.checkRecipientCell("+27718693002"));
    }

    @Test
    public void test06_RecipientCell_Invalid() {
        Message m = new Message();
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
            m.checkRecipientCell("08575975889"));
    }

    @Test
    public void test07_RecipientCell_ValidTrue() {
        Message m = new Message();
        assertTrue(m.isValidRecipientCell("+27838968976"));
    }

    @Test
    public void test08_RecipientCell_InvalidFalse() {
        Message m = new Message();
        assertFalse(m.isValidRecipientCell("08966553"));
    }

    // ===== Message ID Tests =====
    @Test
    public void test09_MessageID_10Digits() {
        Message m = new Message();
        assertEquals(10, m.generateMessageID().length());
    }

    @Test
    public void test10_MessageID_PassesCheck() {
        Message m = new Message();
        assertTrue(m.checkMessageID(m.generateMessageID()));
    }

    @Test
    public void test11_MessageID_TooLongFails() {
        Message m = new Message();
        assertFalse(m.checkMessageID("12345678901"));
    }

    @Test
    public void test12_MessageID_NotNull() {
        Message m = new Message();
        assertNotNull(m.generateMessageID());
    }

    // ===== Message Hash Tests =====
    @Test
    public void test13_Hash_FirstExample() {
        Message m = new Message();
        assertEquals("00:1:HITONIGHT", 
            m.createMessageHash("0000000001", 1, "Hi Mike, can you join us for dinner tonight?"));
    }

    @Test
    public void test14_Hash_SecondExample() {
        Message m = new Message();
        assertEquals("01:2:HIPAYMENT", 
            m.createMessageHash("0100000002", 2, "Hi Keegan, did you receive the payment?"));
    }

    @Test
    public void test15_Hash_Uppercase() {
        Message m = new Message();
        assertEquals("99:5:HELLOWORLD", 
            m.createMessageHash("9999999999", 5, "hello world"));
    }

    // ===== ✅ EXACT RUBRIC MESSAGES =====
    @Test
    public void test16_SendMessage_ReturnsCorrectMessage() {
        Message m = new Message();
        assertEquals("Message successfully sent.", m.sentMessage(1));
    }

    @Test
    public void test17_DisregardMessage_ReturnsCorrectMessage() {
        Message m = new Message();
        assertEquals("Press 0 to delete the message.", m.sentMessage(0));
    }

    @Test
    public void test18_StoreMessage_ReturnsCorrectMessage() {
        Message m = new Message();
        assertEquals("Message successfully stored.", m.sentMessage(2));
    }

    // ===== Total & Print Tests =====
    @Test
    public void test19_TotalMessages() {
        Message m = new Message();
        assertEquals(2, m.returnTotalMessages(2));
        assertEquals(5, m.returnTotalMessages(5));
    }

    @Test
    public void test20_PrintContainsAllDetails() {
        Message m = new Message();
        String output = m.printMessages("1234567890", "12:1:TESTMSG", "+27838968976", "Hello");
        assertTrue(output.contains("1234567890"));
        assertTrue(output.contains("TESTMSG"));
        assertTrue(output.contains("+27838968976"));
    }
}