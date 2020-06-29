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
    @Disabled
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
    }
}