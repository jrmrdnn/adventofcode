
public class Main {
    public static void main(String[] args) {
        int[][] rows = new Row().getAll("data/day1.txt");
        
        int day1 = new AdventOfCode().day1(rows);
        System.out.println("day1: " + day1);

        int day1_2 = new AdventOfCode().day1_2(rows);
        System.out.println("day1_1: " + day1_2);

        int[][] reports = new Report().getAll("data/day2.txt");

        int day2 = new AdventOfCode().day2(reports);
        System.out.println("day2: " + day2);

        int day2_2 = new AdventOfCode().day2_2(reports);
        System.out.println("day2_2: " + day2_2);

        String puzzles = new Puzzle().getAll("data/day3.txt");

        int day3 = new AdventOfCode().day3(puzzles);
        System.out.println("day3: " + day3);

        int day3_2 = new AdventOfCode().day3_2(puzzles);
        System.out.println("day3_2: " + day3_2);

        String[][] puzzlesXmas = new Xmas().getAll("data/day4.txt");

        int day4 = new AdventOfCode().day4(puzzlesXmas);
        System.out.println("day4: " + day4);
    }
}