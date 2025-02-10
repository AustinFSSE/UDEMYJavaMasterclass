import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        String[] names = {"Charlie", "Bravo", "Delta"};
        List<UnaryOperator<String>> list = new ArrayList <>(List.of(
                String::toUpperCase,
                s -> s += " " + names[new Random().nextInt(0,2)].charAt(0) + ".",
                Main::getReversedName

        ));

        // Lambda expressions
//        Arrays.setAll(names, i -> names[i].toUpperCase());
//        System.out.println("Transform to upper case------>");
//        Arrays.asList(names).forEach(System.out::println);
//
//        Arrays.asList(names).replaceAll(s -> s += " " + names[new Random().nextInt(0,2)].charAt(0) + ".");
//        System.out.println("Added a middle initial------>");
//        Arrays.asList(names).forEach(System.out::println);
//
//        Arrays.asList(names).replaceAll(s -> s += " " + getReversedName(s.substring(0, s.indexOf(" "))));
//        System.out.println("First name reversed and added at the end------>");
//        Arrays.asList(names).forEach(System.out::println);

        // now showing the same transformations using method references
        // by utilizing the applyChanges and method referencing

        applyChanges(names, list);


        System.out.println("Hello, World!");
    }
    private static String getReversedName(String firstName) { return new StringBuilder(firstName).reverse().toString(); }

    private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunctions) {
        List<String> backedByArray = Arrays.asList(names);
        for (var function : stringFunctions) {
            backedByArray.replaceAll(s ->s.transform(function));
            System.out.println(Arrays.toString(names));
        }
    }
}