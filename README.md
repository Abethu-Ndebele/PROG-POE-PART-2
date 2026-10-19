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


📚 REFERENCES — Harvard Style

Books
Bates, B. & Sierra, K. 2020. Head First Java. 3rd edn. Sebastopol: O'Reilly Media.
Deitel, P. & Deitel, H. 2021. Java How to Program. 12th edn. Hoboken: Pearson.
Friedl, J.E.F. 2006. Mastering Regular Expressions. 3rd edn. Sebastopol: O'Reilly Media.
Websites
QuickBlox. 2023. A beginner's guide to chat app architecture. [Online]. Available from: https://quickblox.com/blog/beginners-guide-to-chat-app-architecture/ [Accessed 19 Oct 2026].
Videos
Tahch, M. 2021. JUnit 5: A guide to writing unit tests in Java [Video]. YouTube. Available from: https://www.youtube.com/watch?v=MOhiM2SXZl0 [Accessed 17 Oct 2026].
Tahch, M. 2021. Automated testing with GitHub Actions [Video]. YouTube. Available from: https://www.youtube.com/watch?v=oz0Qd5H4Onk [Accessed 17 Oct 2026].
Tahch, M. 2021. Getting started with GitHub Desktop [Video]. YouTube. Available from: https://www.youtube.com/watch?v=bUgFv1Y5LJw [Accessed 17 Oct 2026].
Institutional Documents
The Independent Institute of Education. 2024. Assessment Strategy and Policy (IIE009). Johannesburg: IIE.
The Independent Institute of Education. 2024. Intellectual Integrity and Property Rights Policy (IIE023). Johannesburg: IIE.
