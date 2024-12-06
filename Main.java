public class Main {
    public static void main(String[] args) {
        int[][] rows = new Row().getAll("data/day1.txt");
        
        int day1 = new AdventOfCode().day1(rows);
        System.out.println(day1);

        int day1_2 = new AdventOfCode().day1_2(rows);
        System.out.println(day1_2);

        int[][] reports = new Report().getAll("data/day2.txt");

        int day2 = new AdventOfCode().day2(reports);
        System.out.println(day2);

        int day2_2 = new AdventOfCode().day2_2(reports);
        System.out.println(day2_2);
    }
}