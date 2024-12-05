public class Main {
    public static void main(String[] args) {
        int[][] rows = new Row().getAll("data.txt");
        
        int day1 = new AdventOfCode().day1(rows);
        System.out.println(day1);
    }
}