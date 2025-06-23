import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MailLoginSystem {

    // A HashMap to store email-password pairs for sample users.
    private Map<String, String> userCredentials;

    // Constructor to initialize sample credentials.
    public MailLoginSystem() {
        userCredentials = new HashMap<>();
        userCredentials.put("Saugat420@Sexi.com", "hello123");
        userCredentials.put("AdminSoggy69@hehemail.com", "secureAdminPass");
        userCredentials.put("Johnthedon@org.com", "password123");
    }

    /**
     * Validates the provided email and password against stored credentials.
     *
     * @param email The email ID to validate.
     * @param password The password to validate.
     * @throws InvalidEmailException If the email ID is not registered.
     * @throws WrongCredentialsException If the email is valid but the password is incorrect.
     */
    public void login(String email, String password)
        throws InvalidEmailException, WrongCredentialsException {
        // Check if the email ID exists in the stored credentials.
        if (!userCredentials.containsKey(email)) {
            // If email is not found, throw InvalidEmailException.
            throw new InvalidEmailException(
                "Email ID '" + email + "' is unknown. Please check your email."
            );
        }

        // If the email exists, retrieve the correct password.
        String correctPassword = userCredentials.get(email);

        // Compare the provided password with the correct password.
        if (!correctPassword.equals(password)) {
            // If passwords do not match, throw WrongCredentialsException.
            throw new WrongCredentialsException(
                "Incorrect password for email '" + email + "'."
            );
        }

        // If both checks pass, login is successful.
        System.out.println(
            "Login successful! Welcome to the internal mail service, " +
            email +
            "."
        );
    }

    public static void main(String[] args) {
        MailLoginSystem mailSystem = new MailLoginSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Company Internal Mail Login ---");

        // Loop to allow multiple login attempts.
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter email ID: ");
            String email = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            try {
                // Attempt to log in the user.
                mailSystem.login(email, password);
                loggedIn = true; // Set loggedIn to true on successful login.
            } catch (InvalidEmailException e) {
                // Catch and display the custom InvalidEmailException.
                System.err.println("Login Failed: " + e.getMessage());
                System.out.println(
                    "Please ensure you are using a registered company email."
                );
            } catch (WrongCredentialsException e) {
                // Catch and display the custom WrongCredentialsException.
                System.err.println("Login Failed: " + e.getMessage());
                System.out.println("Password incorrect. Please try again.");
            } finally {
                if (!loggedIn) {
                    System.out.println("\n--- Please try logging in again ---");
                }
            }

            // Optional: Allow exiting the loop
            if (email.equalsIgnoreCase("exit")) {
                break;
            }
        }

        scanner.close(); // Close the scanner.
        System.out.println("--- Mail Login System Closed ---");
    }
}
