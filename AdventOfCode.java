public class AdventOfCode {
    public int day1(int[][] rows) {
        int[] col1 = new Col().getCol(rows, 0);
        // new WriteRowDataToFile().writeRowDataToFile(col1, "col1.txt");
        
        int[] sortCol1 = new Col().getSort(col1);
        // new WriteRowDataToFile().writeRowDataToFile(sortCol1, "sortCol1.txt");

        int[] col2 = new Col().getCol(rows, 1);
        // new WriteRowDataToFile().writeRowDataToFile(col2, "col2.txt");
        
        int[] sortCol2 = new Col().getSort(col2);
        // new WriteRowDataToFile().writeRowDataToFile(sortCol2, "sortCol2.txt");
        
        int[] colDistance = new Col().getDistance(sortCol1, sortCol2);
        // new WriteRowDataToFile().writeRowDataToFile(colDistance, "colDistance.txt");

        return new Row().getSum(colDistance);
    }
}
