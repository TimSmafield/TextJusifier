import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class TextJusifierTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void justifyShouldHandleHappyPath(String input) {

        for ( int i = 120; i < 300; i++) {
            String result = TextJusifier.justify(input, i);
            assertEquals(i, result.length());
        }
    }

    @Test
    void justifyShouldHandleHappyPathManyTimes() {

        for (int i = 20; i < 200; i++) {
            String result = TextJusifier.justify(" Hello      \n World of Java ", i);
            assertEquals(i, result.length());
            assertTrue(result.contains("Hello"));
            assertTrue(result.contains("World"));
            assertTrue(result.contains("of"));
            assertTrue(result.contains("Java"));
        }
    }

    @Test
    void justifyShouldHandleSingleWord() {

        String result =  TextJusifier.justify("Singleton", 20);
        assertEquals("Singleton", result);
    }

    @Test
    void justifyShouldThrowExceptionWithNullLine() {

        assertThrows( IllegalArgumentException.class,() -> {
                String result = TextJusifier.justify(null, 20);
        });
    }

    @Test
    void justifyShouldReturnEmptyLineIfLineIsBlank() {

            String result = TextJusifier.justify("", 20);
            assertTrue(result.isEmpty());
    }

    @Test
    void justifyShouldThrowExceptionWithWhiteSpaceLine() {

        String result = TextJusifier.justify(" ", 20);
        assertTrue(result.isEmpty());
    }

    @Test
    void justifyShouldThrowExceptionWithZeroLength() {

        assertThrows( IllegalArgumentException.class,() -> {
            String result = TextJusifier.justify(" Hello   World  ", 0);
        });
    }

    @Test
    void justifyShouldThrowExceptionSmallLength() {

        RuntimeException thrown = assertThrows( RuntimeException.class,() -> {
            String result = TextJusifier.justify(" Hello   World  ", 3);
        });
        assertEquals("text is too large for line", thrown.getMessage());

    }

}