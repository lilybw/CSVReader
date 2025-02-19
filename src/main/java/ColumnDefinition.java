import exceptions.UncoveredTypeException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

/**
 * Definition of some CSV column including a function for parsing any value in that column
 * @param key if the file includes a
 * @param defaultValue if the field has no value, use the default instead
 * @param <T> class to parse type as
 */
public record ColumnDefinition<T>(String key, ParseFunction<T> parseMethod, T defaultValue) {
    /* package-private */ static final String NO_KEY_SET = "NO_KEY_SET";
    private static final ColumnDefinition<Object> IGNORE_COLUMN = new ColumnDefinition<>(NO_KEY_SET, t -> t, null);

    @SuppressWarnings("unchecked")
    public static <T> ColumnDefinition<T> ignoreColumn() {
        return (ColumnDefinition<T>) IGNORE_COLUMN;
    }

    public static <T> ColumnDefinition<T> of(final Class<T> clazz) {
        if (Type.of(clazz) == Type.UNKNOWN) {
            throw new UncoveredTypeException(clazz + " is not covered by standard parsing methods, do provide custom parser.");
        }
        return new ColumnDefinition<>(
                NO_KEY_SET,
                str -> StandardParser.parse(clazz, str),
                null
        );
    }

    public static ColumnDefinition<Date> date() {
        return new ColumnDefinition<>(
                NO_KEY_SET,
                str -> DateFormat.getDateInstance().parse(str),
                null
        );
    }
    public static ColumnDefinition<Date> date(final SimpleDateFormat format) {
        return new ColumnDefinition<>(
                NO_KEY_SET,
                format::parse,
                null
        );
    }




}
