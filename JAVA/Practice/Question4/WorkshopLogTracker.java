import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Reusing IncompleteDataException from Q3 as it fits the purpose.
// Ensure IncompleteDataException.java is in the same directory.

public class WorkshopLogTracker {

    private static final String INPUT_FILE = "WorkshopLog.txt";
    private static final String OUTPUT_FILE = "SkippedList.txt";

    /**
     * Processes the workshop log file, counting attendees and skipped participants,
     * and writing names of those who skipped to a separate file.
     *
     * @throws FileNotFoundException If the input file does not exist.
     * @throws IOException If an I/O error occurs during file reading or writing.
     */
    public void processWorkshopLog() throws FileNotFoundException, IOException {
        int attendedCount = 0;
        int skippedCount = 0;
        List<String> skippedNames = new ArrayList<>();

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
                    // Split the line by comma. Expected format: FullName, Attended/Skipped
                    String[] parts = line.split(",");
                    // Check if there are exactly two parts.
                    if (parts.length != 2) {
                        throw new IncompleteDataException(
                            "Line " +
                            lineNumber +
                            ": '" +
                            line +
                            "' does not match expected format 'FullName, Attended/Skipped'."
                        );
                    }

                    String fullName = parts[0].trim();
                    String status = parts[1].trim().toLowerCase(); // Convert status to lowercase for case-insensitive comparison.

                    // Determine the attendance status and update counts/list.
                    if (status.equals("attended")) {
                        attendedCount++;
                    } else if (status.equals("skipped")) {
                        skippedCount++;
                        skippedNames.add(fullName); // Add skipped name to the list.
                    } else {
                        // If the status is neither "attended" nor "skipped", consider it malformed.
                        throw new IncompleteDataException(
                            "Line " +
                            lineNumber +
                            ": Invalid status '" +
                            parts[1].trim() +
                            "'. Expected 'Attended' or 'Skipped'."
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
        System.out.println("\n--- Workshop Attendance Summary ---");
        System.out.println("Total Attendees: " + attendedCount);
        System.out.println("Total Skipped: " + skippedCount);

        // Write skipped names to the output file.
        System.out.println(
            "\nAttempting to write skipped names to: " + OUTPUT_FILE
        );
        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            if (skippedNames.isEmpty()) {
                writer.write("No participants skipped the workshop.\n");
                System.out.println("No participants skipped to write.");
            } else {
                for (String name : skippedNames) {
                    writer.write(name + "\n");
                }
                System.out.println(
                    "Successfully wrote " +
                    skippedNames.size() +
                    " skipped names to " +
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
        WorkshopLogTracker tracker = new WorkshopLogTracker();
        // Optional: Create a dummy WorkshopLog.txt for testing
        createDummyWorkshopLogFile();

        try {
            tracker.processWorkshopLog();
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
     * Helper method to create a dummy WorkshopLog.txt file for testing purposes.
     * This method will overwrite any existing file with the same name.
     */
    private static void createDummyWorkshopLogFile() {
        try (FileWriter writer = new FileWriter(INPUT_FILE)) {
            writer.write("John Smith, Attended\n");
            writer.write("Maria Garcia, Skipped\n");
            writer.write("Robert Johnson, Attended\n");
            writer.write("Linda Davis, Skipped\n");
            writer.write("William Brown, Attended\n");
            writer.write("Patricia Wilson, Skipped\n");
            writer.write("James Miller, Present\n"); // Malformed status for this context
            writer.write("Elizabeth Taylor\n"); // Incomplete line
            writer.write("Jennifer Moore, Skipped\n");
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
