package exceptions;

public class UncoveredTypeException extends ParsingException {
    public UncoveredTypeException(Class<?> clazz) {
        super(clazz.toString());
    }

    public UncoveredTypeException(String message) {
        super(message);
    }
}
