import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Row {
    public int[][] getAll(String filename) {
        int[][] rows;

        try {
            List<String> inputs = Files.readAllLines(Paths.get(filename));
            rows = new int[inputs.size()][2];

            int l = inputs.get(0).length();
            int n = (l - 3) / 2;

            for (int i = 0; i < inputs.size(); i++) {
                rows[i][0] = Integer.parseInt(inputs.get(i).substring(0, n));
                rows[i][1] = Integer.parseInt(inputs.get(i).substring(n + 3, l));
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            rows = new int[0][0];
        }

        return rows;
    }

    public int getSum(int[] rows) {
        int sum = 0;

        for (int i = 0; i < rows.length; i++)
            sum += rows[i];
          
        return sum;
    }
}