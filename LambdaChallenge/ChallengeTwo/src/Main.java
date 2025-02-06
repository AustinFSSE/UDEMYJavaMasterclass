
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        Function<String, String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(everySecondChar.apply("1234567890"));

        UnaryOperator <String> printChars = source -> {
            List.of(source).forEach(System.out::println);
            return source;
        };
        System.out.println("-".repeat(20));
        printChars.apply(everySecondChar.apply("1234567890"));

        System.out.println("-".repeat(20));
        String source = "1234567890";
        System.out.println(everySecondCharacter(everySecondChar, source));
    }
    public static String everySecondCharacter(Function<String, String> everySecondChar, String source) {
        return everySecondChar.apply(source);
    }
}