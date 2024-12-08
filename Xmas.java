import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Xmas {
    public String[][] getAll(String filename) {
        String[][] puzzles;

        try {
            List<String> inputs = Files.readAllLines(Paths.get(filename));
            int length = inputs.get(0).length();
            puzzles = new String[inputs.size()][length];

            for (int i = 0; i < inputs.size(); i++) {
                puzzles[i] = inputs.get(i).split("");
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            puzzles = new String[0][0];
        }

        return puzzles;
    }

    public int getCountPuzzleTop(String[][] puzzles, String input) {
        int length = input.length();
        int count = 0;

        for (int i = 0; i < puzzles.length; i++) {
            if (i < length - 1)
                continue;
            for (int y = 0; y < puzzles[i].length; y++)
                if (patternTop(puzzles, i, y, input))
                    count++;
        }

        return count;
    }
    
    public int getCountPuzzleBottom(String[][] puzzles, String input) {
        int inputLength = input.length();
        int puzzlesLength = puzzles.length;
        int count = 0;

        for (int i = 0; i < puzzlesLength; i++) {
            if (i > puzzlesLength - inputLength)
                continue;
            for (int y = 0; y < puzzles[i].length; y++)
                if (patternBottom(puzzles, i, y, input))
                    count++;
        }

        return count;
    }
   
    public int getCountPuzzleRight(String[][] puzzles, String input) {
        int length = input.length();
        int count = 0;

        for (int i = 0; i < puzzles.length; i++)
            for (int y = 0; y < puzzles[i].length; y++) {
                if (y > puzzles[i].length - length)
                    continue;
                if (patternRight(puzzles, i, y, input))
                    count++;
            }

        return count;
    }
    
    public int getCountPuzzleLeft(String[][] puzzles, String input) {
        int length = input.length();
        int count = 0;

        for (int i = 0; i < puzzles.length; i++)
            for (int y = 0; y < puzzles[i].length; y++) {
                if (y < length - 1)
                    continue;
                if (patternLeft(puzzles, i, y, input))
                    count++;
            }

        return count;
    }

    public int getCountPuzzleTopRight(String[][] puzzles, String input) {
        int inputLength = input.length();
        int puzzlesLength = puzzles.length;
        int count = 0;

        for (int i = 0; i < puzzlesLength; i++) {
            if (i < inputLength - 1)
                continue;
            for (int y = 0; y < puzzles[i].length; y++) {
                if (y > puzzles[i].length - inputLength)
                    continue;
                if (patternTopRight(puzzles, i, y, input))
                    count++;
            }
        }
        return count;
    }

    public int getCountPuzzleTopLeft(String[][] puzzles, String input) {
        int inputLength = input.length();
        int puzzlesLength = puzzles.length;
        int count = 0;

        for (int i = 0; i < puzzlesLength; i++) {
            if (i < inputLength - 1)
                continue;
            for (int y = 0; y < puzzles[i].length; y++) {
                if (y < inputLength - 1)
                    continue;
                if (patternTopLeft(puzzles, i, y, input))
                    count++;
            }
        }
        return count;
    }

    public int getCountPuzzleBottomRight(String[][] puzzles, String input) {
        int inputLength = input.length();
        int puzzlesLength = puzzles.length;
        int count = 0;

        for (int i = 0; i < puzzlesLength; i++) {
            if (i > puzzlesLength - inputLength)
                continue;
            for (int y = 0; y < puzzles[i].length; y++) {
                if (y > puzzles[i].length - inputLength)
                    continue;
                if (patternBottomRight(puzzles, i, y, input))
                    count++;
            }
        }
        return count;
    }

    public int getCountPuzzleBottomLeft(String[][] puzzles, String input) {
        int inputLength = input.length();
        int puzzlesLength = puzzles.length;
        int count = 0;

        for (int i = 0; i < puzzlesLength; i++) {
            if (i > puzzlesLength - inputLength)
                continue;
            for (int y = 0; y < puzzles[i].length; y++) {
                if (y < inputLength - 1)
                    continue;
                if (patternBottomLeft(puzzles, i, y, input))
                    count++;
            }
        }
        return count;
    }

    private boolean patternTop(String[][] puzzles, int i, int y, String input) {
        for (int j = 0; j < input.length(); j++) {
            if (!puzzles[i - j][y].equals(input.substring(j, j + 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean patternBottom(String[][] puzzles, int i, int y, String input) {
        for (int j = 0; j < input.length(); j++) {
            if (!puzzles[i + j][y].equals(input.substring(j, j + 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean patternRight(String[][] puzzles, int i, int y, String input) {
        for (int j = 0; j < input.length(); j++) {
            if (!puzzles[i][y + j].equals(input.substring(j, j + 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean patternLeft(String[][] puzzles, int i, int y, String input) {
        for (int j = 0; j < input.length(); j++) {
            if (!puzzles[i][y - j].equals(input.substring(j, j + 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean patternTopRight(String[][] puzzles, int i, int y, String input) {
        for (int j = 0; j < input.length(); j++) {
            if (!puzzles[i - j][y + j].equals(input.substring(j, j + 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean patternTopLeft(String[][] puzzles, int i, int y, String input) {
        for (int j = 0; j < input.length(); j++) {
            if (!puzzles[i - j][y - j].equals(input.substring(j, j + 1))) {
                return false;
            }
        }
        return true;
    }


    private boolean patternBottomRight(String[][] puzzles, int i, int y, String input) {
        for (int j = 0; j < input.length(); j++) {
            if (!puzzles[i + j][y + j].equals(input.substring(j, j + 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean patternBottomLeft(String[][] puzzles, int i, int y, String input) {
        for (int j = 0; j < input.length(); j++) {
            if (!puzzles[i + j][y - j].equals(input.substring(j, j + 1))) {
                return false;
            }
        }
        return true;
    }
}