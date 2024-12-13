import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Update {
    public int[][][] getAll(String filename) {
        List<int[]> puzzle1 = new ArrayList<>();
        List<int[]> puzzle2 = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));

            for (String line : lines)
                if (line.contains("|"))
                    puzzle1.add(parseLine(line, "\\|"));
                else if (line.contains(","))
                    puzzle2.add(parseLine(line, ","));

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            return new int[0][][];
        }

        int[][][] puzzles = new int[2][][];
        puzzles[0] = puzzle1.toArray(int[][]::new);
        puzzles[1] = puzzle2.toArray(int[][]::new);

        return puzzles;
    }
    
    public int getCount(int[][][] updatePuzzles) {
        int count = 0;

        for (int[] puzzle : updatePuzzles[1]) {
            boolean isValid = getValidate(updatePuzzles[0], puzzle);
            if (isValid)
                count += getElementCentral(puzzle);
        }
        
        return count;
    }

    private int[] parseLine(String line, String delimiter) {
        String[] parts = line.split(delimiter);
        int[] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++) 
            numbers[i] = Integer.parseInt(parts[i].trim());

        return numbers;
    }

    private boolean getExists(int[][] puzzles, int[] pair) {
        for (int[] puzzle : puzzles) {
            if (puzzle[0] == pair[0] && puzzle[1] == pair[1]) {
                return true;
            }
        }
        return false;
    }

    private boolean getValidate(int[][] puzzles, int[] line) {
        List<int[]> pairs = getPairs(line);

        for (int[] pair : pairs) {
            if (!getExists(puzzles, pair))
                return false;
        }
        
        return true;
    }
    
    private List<int[]> getPairs(int[] list) {
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            if (i == list.length - 1)
                break;
            else
                pairs.add(new int[] { list[i], list[i + 1] });
        }

        return pairs;
    }
    
    private int getElementCentral(int[] puzzle) {
        int index = puzzle.length / 2;
        return puzzle[index];
    }
}
