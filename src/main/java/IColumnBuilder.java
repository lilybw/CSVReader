public interface IColumnBuilder<T> {

    static <T> IColumnBuilder<T> ofType(final Class<T> clazz) {
        return new ColumnBuilder<>(str -> StandardParser.parse(clazz,str));
    }

    IColumnBuilder<T> knownByKey(String key);

    ColumnDefinition<T> build();
}
