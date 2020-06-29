package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        this.testReporter.publishEntry("running " + testInfo.getDisplayName() + "\n");
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    void tearDown() {
        this.testReporter.publishEntry("cleaning " + testInfo.getDisplayName() + "\n");
    }

    @Nested
    @DisplayName("TDD, string add method, under development")
    class AddTest {
        @Test
        void emptyString() {
            assertAll(
                    () -> assertEquals(0, stringCalculator.add(null), "null string's sum should be 0"),
                    () -> assertEquals(0, stringCalculator.add(""), "empty string's sum should be 0")
            );
        }

        @Test
        void add2Numbers() {
            assertAll(
                    "should correctly add 2 numbers in a string",
                    () -> assertEquals(6, stringCalculator.add("2,4"))
            );
        }

        @Test
        void addingNNumbers() {
            assertAll(
                    "should correctly add n numbers in a string",
                    () -> assertEquals(2 + 5 + 7 + 16, stringCalculator.add("2,5,7,16"))
            );
        }

        @Test
        void handleNewLines() {
            assertAll(
                    "should correctly add a string with newline as delimiter",
                    () -> assertEquals(5 + 10 + 13, stringCalculator.add("\n5\n10,13")),
                    () -> assertEquals(5 + 10 + 13, stringCalculator.add("5\n10,13\n")),
                    () -> assertEquals(5 + 10 + 13, stringCalculator.add("\n5,10\n13,")),
                    () -> assertEquals(5 + 10 + 13, stringCalculator.add("\n5,10\n13\n"))
            );
        }

        /**
         * Support different delimiters
         * to change a delimiter, the beginning of the string will contain a separate line that
         * looks like this: “//[delimiter]\n[numbers…]”
         * for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
         * the first line is optional
         */
        @Test
        @Disabled
        void handleCustomDelimiter() {
            assertAll(
                    "should handle custom delimiter",
                    () -> assertEquals(5 + 8 + 7, stringCalculator.add("//+\n5+8+7")),
                    () -> assertEquals(5 + 8 + 7, stringCalculator.add("//;\n5;8;7")),
                    () -> assertEquals(5 + 8 + 7, stringCalculator.add("//+\n5+8,7"),
                            "should also handle default delimiters")
            );
        }
    }
}