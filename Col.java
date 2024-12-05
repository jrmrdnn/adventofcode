import java.util.Arrays;

public class Col {
        public int[] getCol(int[][] rows, int index) {
        int[] col = new int[rows.length];

        for (int i = 0; i < rows.length; i++) 
            col[i] = rows[i][index];

        return col;
    }
    
    public int[] getSort(int[] col) {
        Arrays.sort(col);
        return col;
    }

    public int[] getDistance(int[] col1, int[] col2) {
        int[] diff = new int[col1.length];

        for (int i = 0; i < col1.length; i++) {
            if (col1[i] >= col2[i])
                diff[i] = col1[i] - col2[i];
            else
                diff[i] = col2[i] - col1[i];
        }
        
        return diff;
    }
}
