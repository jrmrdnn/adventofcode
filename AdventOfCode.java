import java.util.List;

public class AdventOfCode {
    public int day1(int[][] rows) {
        int[] col1 = new Col().getCol(rows, 0);       
        int[] sortCol1 = new Col().getSort(col1);

        int[] col2 = new Col().getCol(rows, 1);        
        int[] sortCol2 = new Col().getSort(col2);
        
        int[] colDistance = new Col().getDistance(sortCol1, sortCol2);

        return new Row().getSum(colDistance);
    }
    
    public int day1_2(int[][] rows) {
        int[] col1 = new Col().getCol(rows, 0);
        int[] col2 = new Col().getCol(rows, 1);

        int[] allSimilarity = new Row().getAllSimilarity(col1, col2);

        return new Row().getSum(allSimilarity);
    }

    public int day2(int[][] reports) {
        return new Level().getSafe(reports);
    }
    
    public int day2_2(int[][] reports) {
        return new Level().getSafeTolerateSingleLevel(reports);
    }

    public int day3(String inputs) {
        List<String> input = new Puzzle().getAllMul(inputs);
        return new Puzzle().getSum(input);
    }

    public int day3_2(String inputs) {
        String puzzle = new Puzzle().splitStrings(inputs);
        List<String> input = new Puzzle().getAllMul(puzzle);
        return new Puzzle().getSum(input);
    }
}
