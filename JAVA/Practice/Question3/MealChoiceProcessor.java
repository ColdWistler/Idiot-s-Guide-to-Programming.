import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MealChoiceProcessor {

    private static final String INPUT_FILE = "MealChoices.txt";
    private static final String OUTPUT_FILE = "NonVegList.txt";

    /**
     * Processes the meal choices file, counting Veg/Non-Veg and
     * writing Non-Veg names to a separate file.
     *
     * @throws FileNotFoundException If the input file does not exist.
     * @throws IOException If an I/O error occurs during file reading or writing.
     */
    public void processMealChoices() throws FileNotFoundException, IOException {
        int vegCount = 0;
        int nonVegCount = 0;
        List<String> nonVegNames = new ArrayList<>();

        System.out.println("Attempting to read from: " + INPUT_FILE);

        // Try-with-resources for BufferedReader ensures the reader is closed automatically.
        try (
            BufferedReader reader = new BufferedReader(
                new FileReader(INPUT_FILE)
            )
        ) {
            String line;
            int lineNumber = 0;
            // Read each line from the file.
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                // Skip empty lines.
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    // Split the line by comma. Expected format: Name, Veg/Non-Veg
                    String[] parts = line.split(",");
                    // Check if there are exactly two parts.
                    if (parts.length != 2) {
                        throw new IncompleteDataException(
                            "Line " +
                            lineNumber +
                            ": '" +
                            line +
                            "' does not match expected format 'Name, Veg/Non-Veg'."
                        );
                    }

                    String name = parts[0].trim();
                    String choice = parts[1].trim().toLowerCase(); // Convert choice to lowercase for case-insensitive comparison.

                    // Determine the meal choice and update counts/list.
                    if (choice.equals("veg")) {
                        vegCount++;
                    } else if (choice.equals("non-veg")) {
                        nonVegCount++;
                        nonVegNames.add(name); // Add non-veg name to the list.
                    } else {
                        // If the choice is neither "veg" nor "non-veg", consider it malformed data for the choice part.
                        throw new IncompleteDataException(
                            "Line " +
                            lineNumber +
                            ": Invalid meal choice '" +
                            parts[1].trim() +
                            "'. Expected 'Veg' or 'Non-Veg'."
                        );
                    }
                } catch (IncompleteDataException e) {
                    // Catch custom IncompleteDataException and print an error message.
                    System.err.println("Data Error: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            // Re-throw FileNotFoundException to be handled by the caller (main method).
            System.err.println("File not found: " + INPUT_FILE);
            throw e;
        } catch (IOException e) {
            // Catch other general IOException errors.
            System.err.println(
                "Error reading file " + INPUT_FILE + ": " + e.getMessage()
            );
            throw e;
        }

        // Display counts to the console.
        System.out.println("\n--- Meal Choice Summary ---");
        System.out.println("Total Veg Choices: " + vegCount);
        System.out.println("Total Non-Veg Choices: " + nonVegCount);

        // Write non-veg names to the output file.
        System.out.println(
            "\nAttempting to write Non-Veg names to: " + OUTPUT_FILE
        );
        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            if (nonVegNames.isEmpty()) {
                writer.write("No Non-Veg choices found.\n");
                System.out.println("No Non-Veg choices to write.");
            } else {
                for (String name : nonVegNames) {
                    writer.write(name + "\n");
                }
                System.out.println(
                    "Successfully wrote " +
                    nonVegNames.size() +
                    " Non-Veg names to " +
                    OUTPUT_FILE
                );
            }
        } catch (IOException e) {
            System.err.println(
                "Error writing to file " + OUTPUT_FILE + ": " + e.getMessage()
            );
            throw e;
        }
    }

    public static void main(String[] args) {
        MealChoiceProcessor processor = new MealChoiceProcessor();
        // Optional: Create a dummy MealChoices.txt for testing
        createDummyMealChoicesFile();

        try {
            processor.processMealChoices();
        } catch (FileNotFoundException e) {
            System.err.println(
                "Application halted: The input file was not found. Please ensure '" +
                INPUT_FILE +
                "' exists."
            );
        } catch (IOException e) {
            System.err.println(
                "Application halted due to an I/O error during file processing."
            );
        }
        System.out.println("\n--- Program finished ---");
    }

    /**
     * Helper method to create a dummy MealChoices.txt file for testing purposes.
     * This method will overwrite any existing file with the same name.
     */
    private static void createDummyMealChoicesFile() {
        try (FileWriter writer = new FileWriter(INPUT_FILE)) {
            writer.write("Alice, Veg\n");
            writer.write("Bob, Non-Veg\n");
            writer.write("Charlie, Veg\n");
            writer.write("David, Non-Veg\n");
            writer.write("Eve, Veg\n");
            writer.write("Frank, Non-Veg\n");
            writer.write("Grace, Vegetarian\n"); // Malformed choice
            writer.write("Heidi\n"); // Incomplete line
            writer.write("Ivan, Non-Veg\n");
            writer.write("\n"); // Empty line
            System.out.println(
                "Dummy '" + INPUT_FILE + "' created for testing."
            );
        } catch (IOException e) {
            System.err.println(
                "Could not create dummy file " +
                INPUT_FILE +
                ": " +
                e.getMessage()
            );
        }
    }
}
