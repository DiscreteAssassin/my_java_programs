import java.util.*;

public class Autobox_Unbox_example {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        String[] inputs = {"10", "20", "30", "40", "50"};
        
        // Parsing strings and adding to the list (Autoboxing)
        for (String input : inputs) {
            numbers.add(parseToInteger(input));
        }
        
        // Calculating sum (Unboxing)
        int sum = calculateSum(numbers);
        
        // Display result
        System.out.println("Sum of numbers: " + sum);
    }
    
    public static Integer parseToInteger(String str) {
        return Integer.parseInt(str); // Autoboxing
    }
    
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing
        }
        return sum;
    }
}
