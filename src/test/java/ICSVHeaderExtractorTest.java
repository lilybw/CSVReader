import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ICSVHeaderExtractorTest {

    @Test
    void trimSharedSequence_simple() {
        List<String> testSeq = List.of(
                "//Hi",
                "//Whats",
                "//Up"
        );

        List<String> expectedSeq = List.of(
                "Hi", "Whats", "Up"
        );

        List<String> actualSeq = ICSVHeaderExtractor.trimSharedSequence(testSeq);
        assertEquals(expectedSeq, actualSeq);
    }
}