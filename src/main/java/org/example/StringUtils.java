package org.example;

public class StringUtils {
    private String delimiterRegex;
    private String actualNumberString;

    /**
     * Extract the actual string without custom delimiter declaration and
     * generates the delimiter regex
     *
     * @param numbers input string with or without delimiter
     * @return string without
     */
    public String extractStringAndGenerateRegex(String numbers) {
        this.delimiterRegex = "[,\\n]";
        actualNumberString = numbers;
        if (numbers != null && numbers.startsWith("//")) {
            numbers = numbers.substring(2);
            String[] delimiterStringArray = numbers.split("\n", 2);
            if (delimiterStringArray.length > 1) {
                String delimiter = delimiterStringArray[0];
                if (!delimiter.equals(",")) {
                    this.delimiterRegex = "[,\\n" + delimiter + "]";
                }
                actualNumberString = delimiterStringArray[1];
            }
        }
        return actualNumberString;
    }

    public String getDelimiterRegex() {
        return delimiterRegex;
    }

    public String getActualNumberString() {
        return actualNumberString;
    }
}