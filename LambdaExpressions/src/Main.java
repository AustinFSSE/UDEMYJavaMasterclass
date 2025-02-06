import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        List <String> list = new ArrayList <String>(List.of("Alpha", "Bravo", "Charlie", "Delta"));

        // Traditional enhanced for loop
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("-".repeat(20));

        // Lambda Expression
        list.forEach(letters -> System.out.println(letters));

        System.out.println("-".repeat(20));

        // Method Reference
        list.forEach(System.out::println);

        System.out.println("-".repeat(20));

        // Custom Lambda expression for a specific result
        list.forEach(letters -> {
            char firstLetter = letters.charAt(0);
            System.out.println(letters + " means " + firstLetter);
        });

        System.out.println("-".repeat(20));
        // Lambda Expression
        int result = calculator((a, b) -> a + b, 5, 2);

        // Method Reference
        var answer = calculator(Integer::sum, 5, 2);

        // Lambda Expression
        var answer2 = calculator((a,b) -> a.toUpperCase() + " " + b.toUpperCase(), "Austin", "Martin");


        System.out.println(".".repeat(20));
        var coords = Arrays.asList(
                new double[] {47.2, -95.2},
                new double[] {29.1, -89.2},
                new double[] {35.1, -90.06});
//        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer< Double, Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println(".".repeat(20));
        coords.forEach(s -> processPoint(s[0], s[1], (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));

        System.out.println(".".repeat(20));
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        System.out.println(".".repeat(20));
        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));
    
        System.out.println(".".repeat(20));
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

        list.replaceAll((s -> s.charAt(0) + "-" + s.toUpperCase()));
        System.out.println(".".repeat(20));
        list.forEach(s -> System.out.println(s));


        System.out.println("-".repeat(20));
        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));

        System.out.println("-".repeat(20));
        Arrays.fill(emptyStrings, " ");
        System.out.println(Arrays.toString(emptyStrings));

        System.out.println("-".repeat(20));
        Arrays.setAll(emptyStrings, i -> " " + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        System.out.println(".".repeat(20));
        Arrays.setAll(emptyStrings, i -> " " + (i + 1) + ". " +
                switch (i) {
                    case 0 -> "one";
                    case 1 -> "two";
                    case 2 -> "three";
                    default -> "null";
                }
        );
        System.out.println(Arrays.toString(emptyStrings));

        System.out.println("-".repeat(20));
        String[] names = {"bob", "ann", "carol"};
        String[] randomLIst = randomlySelectedValues(15, names, () -> new Random().nextInt(0, names.length));
        System.out.println(Arrays.toString(randomLIst));
    }

    public static <T> T calculator(BinaryOperator <T> function, T o1, T o2) {
        T result = function.apply(o1, o2);
        System.out.println("Result: " + result);
        return result;
    }
    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }
    public static String[] randomlySelectedValues ( int count, String[] values, Supplier <Integer> s) {

        String[] selectedValues = new String[count];
        for ( int i = 0; i < count; i++ ) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}