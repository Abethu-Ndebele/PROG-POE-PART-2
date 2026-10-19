/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginapplication;

/**
 *
 * @author Student
 */


import java.util.Random;





public class Message {
    private String messageID;
    private String messageHash;

    // Message ID validation
    public boolean checkMessageID(String id) {
        return id != null && id.length() <= 10;
    }

    // Generate 10-digit unique ID
    public String generateMessageID() {
        Random rand = new Random();
        messageID = String.format("%010d", rand.nextInt(1000000000));
        return messageID;
    }

    // Recipient cell validation — +27 only, exactly 9 digits
    public String checkRecipientCell(String cell) {
        if (cell != null && cell.matches("^\\+27\\d{9}$")) {
            return "Cell phone number successfully captured.";
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    public boolean isValidRecipientCell(String cell) {
        return cell != null && cell.matches("^\\+27\\d{9}$");
    }

    // Message length validation
    public String validateMessageLength(String text) {
        if (text == null) text = "";
        if (text.length() <= 250) {
            return "Message ready to send.";
        }
        int over = text.length() - 250;
        return "Message exceeds 250 characters by " + over + "; please reduce the size.";
    }

    public boolean isMessageValidLength(String text) {
        return text != null && text.length() <= 250;
    }

    // Create message hash
    public String createMessageHash(String id, int num, String text) {
        String firstTwo = id.substring(0, 2);
        String[] words = text.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0].toUpperCase().replaceAll("[^A-Z]", "") : "";
        String lastWord = words.length > 0 ? words[words.length - 1].toUpperCase().replaceAll("[^A-Z]", "") : "";
        messageHash = firstTwo + ":" + num + ":" + firstWord + lastWord;
        return messageHash;
    }

    //  EXACT MESSAGES FROM RUBRIC
    public String sentMessage(int choice) {
        if (choice == 1) {
            return "Message successfully sent.";
        } else if (choice == 0) {
            return "Press 0 to delete the message.";
        } else if (choice == 2) {
            return "Message successfully stored.";
        }
        return "Invalid option selected.";
    }

    // Format message for display
    public String printMessages(String id, String hash, String recipient, String text) {
        return "Message ID: " + id + "\n"
             + "Message Hash: " + hash + "\n"
             + "Recipient: " + recipient + "\n"
             + "Message: " + text;
    }

    public int returnTotalMessages(int total) {
        return total;
    }
}