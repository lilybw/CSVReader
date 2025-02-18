/**
 * Definition of some CSV column
 * @param key if the file includes a
 * @param defaultValue if the field has no value, use the default instead
 * @param <T> class to parse type as
 */
public record ColumnDefinition<T>(String key, Class<T> clazz, T defaultValue) {
    private static final String NO_KEY_SET = "NO_KEY_SET";

    public static <T> ColumnDefinition<T> from(Class<T> clazz) {
        return new ColumnDefinition<>(NO_KEY_SET, clazz, null);
    }

}
