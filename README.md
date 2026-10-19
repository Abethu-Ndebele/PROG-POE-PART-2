# PROG-POE-PART-2
PROG5121 PoE Part 2 — QuickChat Messaging Feature. Java application that extends the login system, validates +27 cellphone number format using regex, generates unique message IDs &amp; hashes, enforces 250-character limits. Includes console menu UI, JUnit tests and full messaging flow.

## 📌 Part 2 — QuickChat Messaging System

### 📝 Description
Part 2 extends the existing user registration and login system into a fully functional console-based messaging application. Building upon the authentication system developed in Part 1, this component introduces secure access control, message management, and automated data generation — ensuring users can only access messaging features after successful verification.

The application enforces strict South African phone number validation, allowing **only numbers starting with `+27` followed by exactly 9 digits**. It generates unique 10-digit message identifiers and cryptographic-style hashes for every message, while validating message length against a 250-character limit. Users define their message volume at startup and interact through a clean numeric menu interface, with development placeholders for future features.

### ✅ Key Enhancements & New Features
- **Restricted Access** — Messaging features are completely inaccessible until login succeeds
- **Welcome Screen** — Displays `"Welcome to QuickChat."` immediately upon authentication
- **Interactive Menu** — Three-option navigation: Send Messages, Show Sent Messages, Quit
- **Message Management** — Compose, preview, and choose to Send, Disregard, or Store each message
- **Strict Phone Validation** — Enforces `+27XXXXXXXXX` format; rejects all other country codes and malformed entries
- **ID Generation** — Automatically assigns a unique 10-digit identifier to every message
- **Hash Construction** — Builds a reference hash using the message ID, sequence number, and extracted words from message content
- **Volume Control** — User specifies how many messages to enter; application enforces the limit
- **Exact Feedback Messaging** — All system responses match specification word-for-word
- **Comprehensive Testing** — 20 additional unit tests validating all message logic and outputs

### 🔧 Technical Implementation
- **Language**: Java 17+
- **Architecture**: Two-class modular design (`LoginSystem` for auth, `Message` for messaging logic)
- **Input Handling**: Real-time validation with immediate retry prompts for all invalid entries
- **Unit Testing**: JUnit 5 — 20 tests covering message length, format, actions, and data generation
- **Validation Engine**: Regular expressions ensure consistent formatting across all phone numbers
- **State Management**: Maintains message count and collection throughout the session lifecycle

### 📋 Compliance Highlights
- Usernames validated for underscore inclusion and maximum length
- Passwords checked for minimum 8 characters, uppercase, numeric, and special characters
- Separate error messages for invalid username vs password during login
- Disregard option returns `"Press 0 to delete the message."` exactly as specified
- All outputs conform to POE rubric requirements
- 100% test coverage across both Part 1 and Part 2 functionality
