import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer <String> printWords = new Consumer <String>() {
            @Override
            public void accept(String s) {
                String[] parts = s.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };
        Consumer <String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        printWords.accept("null null null");
        System.out.println("-".repeat(20));
        printWordsLambda.accept("null null null");

        Consumer <String> printWordsForEach= sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };
        System.out.println("-".repeat(20));
        printWordsForEach.accept("null null null");

        Consumer <String> printWordsConcise= sentence -> {
            Arrays.asList(sentence.split(" ")).
                    forEach(s -> System.out.println(s));
        };
        System.out.println("-".repeat(20));
        printWordsConcise.accept("null null null");
    }
}