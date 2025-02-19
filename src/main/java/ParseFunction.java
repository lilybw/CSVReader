import java.text.ParseException;

public interface ParseFunction<T> {
    T parse(String s) throws ParseException;
}
