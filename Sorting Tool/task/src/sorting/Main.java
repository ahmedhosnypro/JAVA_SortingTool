package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> nums = new ArrayList<>();

        while (scanner.hasNextLong()) {
            long number = Long.parseLong(scanner.next());
            nums.add(number);
        }
        System.out.println("Total numbers: " + nums.size() + ".");
        Optional<Long> optionalMax = nums.stream().max(Long::compareTo);
        if (optionalMax.isPresent()) {
            long max = optionalMax.get();
            long maxCount = nums.stream()
                    .filter(n -> n == max)
                    .count();
            System.out.println("The greatest number: " + max + " (" + maxCount + " time(s))");
        }
    }
}
