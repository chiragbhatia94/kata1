package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    StringUtils stringUtils;

    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        this.testReporter.publishEntry("running " + testInfo.getDisplayName() + "\n");
        stringUtils = new StringUtils();
    }

    @AfterEach
    void tearDown() {
        this.testReporter.publishEntry("cleaning " + testInfo.getDisplayName() + "\n");
    }

    /**
     * Support different delimiters
     * to change a delimiter, the beginning of the string will contain a separate line that
     * looks like this: “//[delimiter]\n[numbers…]”
     * for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
     * the first line is optional
     */
    @Nested
    class CustomDelimiter {
        @Test
        void handleCustomDelimiterExtraction() {
            stringUtils.extractStringAndGenerateRegex("//+\n5+8,7");
            assertAll(
                    "should handle custom delimiter",
                    () -> assertEquals("[,\\n+]", stringUtils.getDelimiterRegex()),
                    () -> assertEquals("5+8,7", stringUtils.getActualNumberString())
            );
        }
    }

}