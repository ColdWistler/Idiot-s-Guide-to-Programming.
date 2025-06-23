import java.util.HashMap;
import java.util.Scanner;

class InvalidEmailException extends Exception {

    public InvalidEmailException(String message) {
        super(message);
    }
}

class WrongCredentialsException extends Exception {

    public WrongCredentialsException(String message) {
        super(message);
    }
}

public class MailLogin {

    public static void main(String[] args) {
        HashMap<String, String> emailMap = new HashMap<>();
        emailMap.put("user01@org.com", "hello123");
        emailMap.put("user02@org.com", "welcome456");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            if (!emailMap.containsKey(email)) {
                throw new InvalidEmailException("Email not found.");
            }

            if (!emailMap.get(email).equals(password)) {
                throw new WrongCredentialsException("Wrong password.");
            }

            System.out.println("Login successful!");
        } catch (InvalidEmailException | WrongCredentialsException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}
