import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Report {
    public int[][] getAll(String filename) {
        int[][] reports;

        try {
            List<String> list = Files.readAllLines(Paths.get(filename));
            int listSize = list.size();
            reports = new int[listSize][];

            for (int i = 0; i < listSize; i++) {
                String[] split = list.get(i).split(" ");
                reports[i] = new int[split.length];

                for (int j = 0; j < split.length; j++) 
                    reports[i][j] = Integer.parseInt(split[j]);
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            reports = new int[0][0];
        }
        return reports;
    }
}
