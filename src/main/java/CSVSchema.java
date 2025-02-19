import jdk.jshell.spi.ExecutionControl;

/**
 * A schema for deserializing a cell in each column
 */
public interface CSVSchema<C0,C1,C2,C3,C4,C5,C6,C7,C8,C9> {

    /**
     * Establish a schema for a CSV file of 4 columns
     */
    static <C0,C1,C2,C3> CSVSchema<C0,C1,C2,?,?,?,?,?,?,?> from(
            ColumnDefinition<C0> c0Def,
            ColumnDefinition<C1> c1Def,
            ColumnDefinition<C2> c2Def,
            ColumnDefinition<C3> c3Def
    ) {

        throw new RuntimeException("Not implemented");
    }

    ICSVHeaderExtractor getHeaderExtractor();


}
