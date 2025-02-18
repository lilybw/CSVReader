import exceptions.DataKeyNotFoundInconvenience;
import exceptions.EmptyDataKeyInconvenience;

import java.util.List;

/**
 * As part of the header, one line may describe what each column repressents. If this is consistent
 * this definition can be used to automatically map columns to what the schema has been set up to expect.
 * <br/>
 * This re-arrangement happens before parsing, and eagerly, however, for larger dataset this might not
 * be preferable.
 */
public interface ICSVDataKeyExtractor {

    /**
     * What line of the header to use as the data key. 0 indexed.
     */
    static ICSVDataKeyExtractor fromLineInHeader(final int lineNumber) {
        return (strs, separator) -> strs.get(lineNumber).split(separator);
    }

    /**
     * Find the line starting with some specific symbols and use that.
     * i.e. if the line with the key starts with "key: ", or "@" or, ... etc
     * @param symbols to look for
     */
    static ICSVDataKeyExtractor fromLineMarkedBy(final String symbols) {
        return (header, separator) -> {
            String dataKeyLine = null;
            for (String str : header) {
                if (str.startsWith(symbols)) {
                    dataKeyLine = str.substring(symbols.length());
                }
            }
            if (dataKeyLine == null) {
                throw new DataKeyNotFoundInconvenience("Unable to locate data key from symbols \"" + symbols + "\" and header: " + header);
            }
            if (dataKeyLine.isEmpty()) {
                throw new EmptyDataKeyInconvenience("Located data key from symbols \"" + symbols + "\" but it was empty.");
            }
            return dataKeyLine.split(separator);
        };
    }

    String[] extractKeySet(final List<String> header, final String separator);
}
