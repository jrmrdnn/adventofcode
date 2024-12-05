import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteRowDataToFile {
    public void writeRowDataToFile(int[] rows, String filename) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            for (int row : rows) {
                writer.write(String.valueOf(row));
                if (row != rows[rows.length - 1]) writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public void writeRowDataToFile(int[][] rows, String filename) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            for (int[] row : rows) {
                writer.write(row[0] + " " + row[1]);
                if (row != rows[rows.length - 1]) writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
    
