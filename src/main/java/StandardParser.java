import exceptions.ParsingException;
import exceptions.UncoveredTypeException;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

public class StandardParser {

    /**
     * Throws when a class it cannot parse is given
     * @param clazz Class to parse the bytes as
     * @param value to be parsed
     * @return A valid instance of some type T - or null if the input clazz is either NoParse or... you guessed it... null.
     * @throws ParsingException - Either when the given clazz is not supported or if there isn't enough bytes to parse an instance of said type.
     */
    public static <T> T parse(Class<T> clazz, String value) throws ParsingException {
        try{
            return (T) switch (Type.of(clazz)) {
                case NULL -> null;
                case INT8 -> Byte.parseByte(value);
                case INT16 -> Short.parseShort(value);
                case INT32 -> Integer.parseInt(value);
                case INT64 -> Long.parseLong(value);
                case FLOAT32 -> Float.parseFloat(value);
                case FLOAT64 -> Double.parseDouble(value);
                case STRING -> value;
                case DATE -> DateFormat.getDateInstance().parse(value);
                case INSTANT -> Instant.parse(value);
                default -> throw new UncoveredTypeException(clazz);
            };
        }catch (NullPointerException e){
            throw new ParsingException("Provided string is null, expected something that could be parsed as: " + clazz);
        }catch (NumberFormatException | java.text.ParseException  e){
            throw new ParsingException("Provided string: \""+value+"\" cant be parsed as: " + clazz + ": " + e.getMessage());
        }
    }

}
