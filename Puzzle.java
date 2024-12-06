import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle {
    public String getAll(String filename) {
        List<String> inputs = new ArrayList<>();
        String target = "";

        try {
            inputs = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        for (String input : inputs) {
            target += input;
        }

        return target;
    }
    
    public List<String> getAllMul(String input) {
        List<String> matches = new ArrayList<>();

        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        return matches;
    }
    
    public String splitStrings(String input) {
        List<String> inputs = new ArrayList<>();
        String[] splitDo = input.split("do\\(\\)");

        for (String part : splitDo) 
            inputs.add(part.split("don't\\(\\)")[0]);
        
        return String.join("", inputs);
    }
    
    public int getSum(List<String> matches) {
        int sum = 0;
        
        for (String match : matches) {
            String[] numbers = match.replaceAll("[^0-9,]", "").split(",");
            int num1 = Integer.parseInt(numbers[0]);
            int num2 = Integer.parseInt(numbers[1]);
            sum += num1 * num2;
        }
        
        return sum;
    }
}
