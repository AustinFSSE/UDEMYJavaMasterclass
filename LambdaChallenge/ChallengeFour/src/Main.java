import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<String> s = () -> "I love java!";
        Supplier<String> s2 = () -> { return "I love java!"; };

        var iLoveJava = s.get();
        System.out.println(iLoveJava);
        var iLoveJava2 = s2.get();
        System.out.println(iLoveJava2);
    }
}