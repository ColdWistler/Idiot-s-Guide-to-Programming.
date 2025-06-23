import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniversityClubAccess {

    // A HashMap to store member credentials (username -> password).
    private Map<String, String> members;

    // Constructor to initialize the member credentials.
    public UniversityClubAccess() {
        members = new HashMap<>();
        // Add some sample member credentials for testing.
        members.put("SexiSaugat", "Sexi123");
        members.put("AlsoSexiSaugat", "69420Sexi");
        members.put("GaySarun", "Sarun6Sexi");
    }

    /**
     * Authenticates a user based on provided username and password.
     *
     * @param username The username to check.
     * @param password The password to check.
     * @throws MemberNotRegisteredException If the username does not exist in the system.
     * @throws AccessDeniedException If the username exists but the password does not match.
     */
    public void authenticate(String username, String password)
        throws MemberNotRegisteredException, AccessDeniedException {
        // Check if the username exists in the members map.
        if (!members.containsKey(username)) {
            // If username is not found, throw MemberNotRegisteredException.
            throw new MemberNotRegisteredException(
                "Username '" + username + "' is not registered."
            );
        }

        // If the username exists, get the stored password and compare.
        String storedPassword = members.get(username);
        if (!storedPassword.equals(password)) {
            // If passwords do not match, throw AccessDeniedException.
            throw new AccessDeniedException(
                "Incorrect password for username '" +
                username +
                "'. Access denied."
            );
        }

        // If both checks pass, authentication is successful.
        System.out.println(
            "Authentication successful! Welcome, " + username + "."
        );
        System.out.println("You can now view internal club content.");
    }

    public static void main(String[] args) {
        UniversityClubAccess system = new UniversityClubAccess();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- University Club Secure Access System ---");

        // Loop to allow multiple login attempts until a valid login or user exits.
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            try {
                // Attempt to authenticate the user.
                system.authenticate(username, password);
                loggedIn = true; // Set loggedIn to true if authentication is successful.
            } catch (MemberNotRegisteredException e) {
                // Catch and display the custom MemberNotRegisteredException.
                System.err.println("Login Failed: " + e.getMessage());
                System.out.println(
                    "Please try again or register if you are a new member."
                );
            } catch (AccessDeniedException e) {
                // Catch and display the custom AccessDeniedException.
                System.err.println("Login Failed: " + e.getMessage());
                System.out.println("Double-check your password.");
            } finally {
                // This block will always execute after try/catch, useful for cleanup or prompts.
                if (!loggedIn) {
                    System.out.println("\n--- Try again ---");
                }
            }

            // Optional: Add a way to exit the loop if desired (e.g., typing 'exit' for username)
            if (username.equalsIgnoreCase("exit")) {
                break;
            }
        }

        scanner.close(); // Close the scanner to prevent resource leaks.
        System.out.println("--- Access System Closed ---");
    }
}
