import java.util.HashMap;
import java.util.Scanner;

class MemberNotRegisteredException extends Exception {

    public MemberNotRegisteredException(String message) {
        super(message);
    }
}

class AccessDeniedException extends Exception {

    public AccessDeniedException(String message) {
        super(message);
    }
}

public class ClubLogin {

    public static void main(String[] args) {
        HashMap<String, String> members = new HashMap<>();
        members.put("SimpleSexiSaugat", "pass123");
        members.put("bobthebuilder", "secret456");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            if (!members.containsKey(username)) {
                throw new MemberNotRegisteredException("User not registered.");
            }

            if (!members.get(username).equals(password)) {
                throw new AccessDeniedException("Incorrect password.");
            }

            System.out.println("Access granted!");
        } catch (MemberNotRegisteredException | AccessDeniedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
