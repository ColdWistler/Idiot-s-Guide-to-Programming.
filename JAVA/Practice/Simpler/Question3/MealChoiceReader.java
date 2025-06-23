import java.io.*;
import java.util.*;

class IncompleteDataException extends Exception {

    public IncompleteDataException(String msg) {
        super(msg);
    }
}

public class MealChoiceReader {

    public static void main(String[] args) {
        int vegCount = 0, nonVegCount = 0;
        List<String> nonVegNames = new ArrayList<>();

        try (
            BufferedReader br = new BufferedReader(
                new FileReader("MealChoices.txt")
            );
            PrintWriter pw = new PrintWriter("NonVegList.txt")
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) {
                    throw new IncompleteDataException("Invalid line: " + line);
                }

                String name = parts[0].trim();
                String choice = parts[1].trim().toLowerCase();

                if (choice.equals("veg")) {
                    vegCount++;
                } else if (choice.equals("non-veg")) {
                    nonVegCount++;
                    nonVegNames.add(name);
                } else {
                    throw new IncompleteDataException(
                        "Unknown choice: " + choice
                    );
                }
            }

            for (String name : nonVegNames) {
                pw.println(name);
            }

            System.out.println(
                "Veg: " + vegCount + ", Non-Veg: " + nonVegCount
            );
        } catch (FileNotFoundException e) {
            System.out.println("MealChoices.txt file not found!");
        } catch (IncompleteDataException e) {
            System.out.println("Data error: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
