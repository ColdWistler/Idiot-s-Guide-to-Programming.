import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AttendanceCounter {

    /**
     * Reads an attendance file and counts the number of "Present" and "Absent" entries.
     * The method expects each line in the file to contain either "Present" or "Absent"
     * (case-insensitive), or other text that will be ignored for counting.
     *
     * @param filePath The path to the attendance text file.
     * @return A Map containing the counts for "Present" and "Absent".
     * The keys are "Present" and "Absent", and values are their respective counts.
     * Returns an empty map if the file cannot be read or contains no relevant data.
     */
    public Map<String, Integer> countAttendance(String filePath) {
        // Initialize a HashMap to store the counts for "Present" and "Absent".
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Present", 0); // Initialize present count to 0
        counts.put("Absent", 0); // Initialize absent count to 0

        // Use a try-with-resources statement to ensure the BufferedReader is closed automatically.
        try (
            BufferedReader reader = new BufferedReader(new FileReader(filePath))
        ) {
            String line;
            // Read the file line by line until the end of the file is reached.
            while ((line = reader.readLine()) != null) {
                // Convert the line to lowercase to make the comparison case-insensitive.
                String trimmedLine = line.trim().toLowerCase();

                // Check if the line contains "present" and update the count.
                if (trimmedLine.contains("present")) {
                    counts.put("Present", counts.get("Present") + 1);
                }
                // Check if the line contains "absent" and update the count.
                else if (trimmedLine.contains("absent")) {
                    counts.put("Absent", counts.get("Absent") + 1);
                }
                // Lines not containing "present" or "absent" will be ignored.
            }
        } catch (IOException e) {
            // Catch IOException in case of issues like file not found, permission denied, etc.
            System.err.println("Error reading the file: " + e.getMessage());
            // Optionally, you might want to return the current (possibly zero) counts or re-throw the exception.
        }
        return counts; // Return the map with the final counts.
    }

    /**
     * Main method to demonstrate the AttendanceCounter functionality.
     * This method creates a dummy file (if it doesn't exist) for testing purposes
     * and then uses the countAttendance method to process it.
     */
    public static void main(String[] args) {
        // Define the path for the attendance file.
        String attendanceFile = "attendance.txt";

        // --- Optional: Create a dummy attendance file for testing ---
        // You can comment out this block if you already have an attendance.txt file
        // or prefer to create it manually.
        try (
            java.io.FileWriter writer = new java.io.FileWriter(attendanceFile)
        ) {
            writer.write("John Doe: Present\n");
            writer.write("Jane Smith: Absent\n");
            writer.write("Peter Jones: Present\n");
            writer.write("Alice Brown: Absent\n");
            writer.write("Another Person: Present\n");
            writer.write("A long line with some absent status somewhere\n"); // Example of line containing keyword
            writer.write("Someone is not here, so absent\n"); // Another example
            writer.write("A random line with no attendance status.\n");
            System.out.println("Dummy attendance.txt created for testing.");
        } catch (IOException e) {
            System.err.println(
                "Could not create dummy file: " + e.getMessage()
            );
            // Exit if cannot create file, as subsequent operations will fail
            return;
        }
        AttendanceCounter counter = new AttendanceCounter();
        System.out.println("\nCounting attendance from: " + attendanceFile);
        Map<String, Integer> result = counter.countAttendance(attendanceFile);

        // Print the results.
        if (!result.isEmpty()) {
            System.out.println("Attendance Summary:");
            System.out.println("Number of Present: " + result.get("Present"));
            System.out.println("Number of Absent: " + result.get("Absent"));
        } else {
            System.out.println(
                "No attendance data found or file could not be read."
            );
        }
    }
}
// --- End of dummy file creation ---
