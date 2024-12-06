public class Level {
    private boolean isSafe(int[] report) {
        boolean asc = report[0] < report[1];
        boolean isSafe = true;
        int previous = 0;
        int gap;
        
        for (int i = 0; i < report.length; i++) {
            if (i == 0) {
                previous = report[i];
                continue;
            }

            if (asc) gap = report[i] - previous;
            else gap = previous - report[i];
            
            if (gap > 3 || gap <= 0) {
                isSafe = false;
                break;
            }

            previous = report[i];
        }

        return isSafe;
    }
    
    private boolean isSafeTolerateSingleLevel(int[] report) {
        boolean isSafe = false;
        int[][] reportOneTolerate = removeOneElement(report);

        for (int[] r : reportOneTolerate) {
            if (isSafe(r)) {
                isSafe = true;
                break;
            }
        }

        return isSafe;
    }
    
    public int getSafe(int[][] reports) {
        int countSafe = 0;

        for (int[] report : reports)
            if (isSafe(report)) countSafe++;

        return countSafe;
    }

    public int getSafeTolerateSingleLevel(int[][] reports) {
        int countSafe = 0;

        for (int[] report : reports) {
            if (isSafe(report)) 
                countSafe++;
            else if (isSafeTolerateSingleLevel(report))
                countSafe++;
        }

        return countSafe;
    }

    public int[][] removeOneElement(int[] array) {
        int[][] result = new int[array.length][];

        for (int i = 0; i < array.length; i++) {
            int[] newArray = new int[array.length - 1];

            for (int j = 0, k = 0; j < array.length; j++) 
                if (j != i) newArray[k++] = array[j];
            
            result[i] = newArray;
        }

        return result;
    }
}
