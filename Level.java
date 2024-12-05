public class Level {
    private boolean isSafe(int[] report) {
        if (report[0] == report[1])
            return false;

        boolean isSafe = true;
        int previous = report[0];
        boolean asc = report[0] < report[1];
        

        for (int i = 1; i < report.length; i++) {
            int gap;

            if (asc) gap = report[i] - previous;
            else
                gap = previous - report[i];
            
            if (gap > 3 || gap <= 0) {
                isSafe = false;
                break;
            }
            previous = report[i];
        }

        return isSafe;
    }
    
    public int getSafe(int[][] reports) {
        int countSafe = 0;

        for (int[] report : reports) {
            if (isSafe(report))
                countSafe++;
        }

        return countSafe;
    }
}
