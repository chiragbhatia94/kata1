package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                String delimitersString = delimiterStringArray[0];
                List<String> delimitersList = new ArrayList<>();
                // for handling multiple delimiters
                if (delimitersString.matches("\\[.*\\]")) {
                    delimitersString = delimitersString.substring(1, delimitersString.length() - 1);
                    delimitersList = Arrays.asList(delimitersString.split("]\\["));
                } else {
                    delimitersList.add(delimitersString);
                }
                this.delimiterRegex = "[,\\n";
                for (String delimiter : delimitersList) {
                    if (!delimiter.equals(",")) {
                        this.delimiterRegex = this.delimiterRegex.concat(delimiter);
                    }
                }
                this.delimiterRegex = this.delimiterRegex.concat("]");
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