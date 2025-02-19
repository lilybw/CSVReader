class ColumnBuilder<T> implements IColumnBuilder<T> {

    private String key = ColumnDefinition.NO_KEY_SET;
    private final ParseFunction<T> parseFunction;

    public ColumnBuilder(ParseFunction<T> parseFunction) {
        this.parseFunction = parseFunction;
    }

    @Override
    public IColumnBuilder<T> knownByKey(String key) {
        this.key = key;
        return this;
    }

    @Override
    public ColumnDefinition<T> build() {
        return new ColumnDefinition<>(key, parseFunction, null);
    }
}
