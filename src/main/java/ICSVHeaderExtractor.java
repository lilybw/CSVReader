import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Some CSV files may include a header, i.e. a couple of (hopefully) commented-out lines
 * describing the contents.
 */
public interface ICSVHeaderExtractor {

    static ICSVHeaderExtractor firstNLines(final int amount) {
        return stream -> trimSharedSequence(stream.limit(amount).toList())
                .stream().map(String::trim).toList();
    }

    static ICSVHeaderExtractor allLinesStartingWith(final String str) {
        return stream -> stream.takeWhile(
                    line -> line.startsWith(str)
                ).map(
                    line -> line.replaceFirst(str, "")
                ).map(
                    String::trim
                ).toList();
    }

    /**
     * For any number of strings, remove any part from the start that is shared between all.
     * <pre>{@code
     * //Hi
     * //Whats
     * //Up
     *
     * Becomes
     *
     * Hi
     * Whats
     * Up
     * }</pre>
     */
    static List<String> trimSharedSequence(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return strings;
        }

        // Find the length of the shortest string
        int minLength = strings.stream()
                .mapToInt(String::length)
                .min()
                .orElse(0);

        // Find the maximum shared sequence length
        int maxSharedLength = 0;
        for (int i = 0; i < minLength; i++) {
            char charOfFirstString = strings.getFirst().charAt(i);
            boolean allMatch = true;
            for (int j = 1; j < strings.size(); j++) {
                if (strings.get(j).charAt(i) != charOfFirstString) {
                    allMatch = false;
                    break;
                }
            }
            if (!allMatch) break;
            maxSharedLength++;
        }

        final int asFinalMaxSharedLength = maxSharedLength;

        // Trim the shared sequence from all strings
        return strings.stream().map(str -> str.substring(asFinalMaxSharedLength)).toList();
    }

    /**
     * Extracts full header from stream and removes any prefixes and the like
     * @throws IOException
     */
    List<String> extractHeader(Stream<String> stream) throws IOException;

}
