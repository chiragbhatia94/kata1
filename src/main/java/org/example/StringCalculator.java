package org.example;

public class StringCalculator {
    /**
     * Calculate sum of all the numbers in a string
     * @param numbers string of numbers
     * @return sum of numbers
     */
    public int add(String numbers) {
        // handle empty string
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        String[] numberArray = numbers.split("[,\\n]");
        int sum = 0;
        for (String numberString: numberArray) {
            if (numberString.isEmpty()) {
                continue;
            }
            int number = Integer.parseInt(numberString);
            sum += number;
        }
        return sum;
    }
}
