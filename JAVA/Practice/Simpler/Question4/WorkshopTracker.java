import java.io.*;
import java.util.*;

class MalformedLineException extends Exception {

    public MalformedLineException(String message) {
        super(message);
    }
}

public class WorkshopTracker {

    public static void main(String[] args) {
        int attended = 0, skipped = 0;
        List<String> skippedList = new ArrayList<>();

        try (
            BufferedReader br = new BufferedReader(
                new FileReader("WorkshopLog.txt")
            );
            PrintWriter pw = new PrintWriter("SkippedList.txt")
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) {
                    throw new MalformedLineException("Invalid line: " + line);
                }

                String name = parts[0].trim();
                String status = parts[1].trim().toLowerCase();

                if (status.equals("attended")) {
                    attended++;
                } else if (status.equals("skipped")) {
                    skipped++;
                    skippedList.add(name);
                } else {
                    throw new MalformedLineException(
                        "Unknown status: " + status
                    );
                }
            }

            for (String name : skippedList) {
                pw.println(name);
            }

            System.out.println(
                "Attended: " + attended + ", Skipped: " + skipped
            );
        } catch (FileNotFoundException e) {
            System.out.println("WorkshopLog.txt not found.");
        } catch (MalformedLineException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
