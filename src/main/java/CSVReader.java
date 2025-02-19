import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class CSVReader<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9>
        implements Iterable<IRowView<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9>>, AutoCloseable {

    private final Stream<String> lineStream;
    private final CSVSchema<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9> schema;
    private final List<String> header;
    private final List<IRowView<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9>> body = new ArrayList<>();

    public CSVReader(String url, CSVSchema<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9> schema) throws IOException {
        this.lineStream = new BufferedReader(new FileReader(url)).lines();
        this.schema = schema;
        this.header = schema.getHeaderExtractor().extractHeader(lineStream);
    }

    /** Index into a specific row in the file, starting after the header (if any).
     * If this row has not been loaded yet, the reader will advance to this point. */
    public IRowView<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9> row(int index) throws IndexOutOfBoundsException, IllegalArgumentException {
        if ( index < 0 ) throw new IllegalArgumentException("Number cannot be negative");

        final int leftToRead = body.size() - index;
        if (leftToRead < 0) {
            return body.get(index);
        }
    }

    @Override
    public Iterator<IRowView<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9>> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public IRowView<C0, C1, C2, C3, C4, C5, C6, C7, C8, C9> next() {
                return null;
            }
        };
    }

    @Override
    public void close() throws Exception {
        lineStream.close();
    }
}
