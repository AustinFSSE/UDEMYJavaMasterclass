import java.util.*;



public class Main {

    public static void main(String[] args) {

        String[] names = {"John", "Mary", "Jane", "Bob", "Anna"};
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F'};

        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.print("Transform to upper case: ");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);

        backedByArray.replaceAll(s -> s += " " + letters[new Random().nextInt(letters.length)] + ".");
        System.out.println("Added a random middle initial: " + backedByArray);

        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        Arrays.asList(names).forEach(System.out::println);

        List<String> newLIst = new ArrayList<>(List.of(names));


        newLIst.removeIf(s -> {
            String firstword = s.substring(0, s.indexOf(" "));
            String secondword = s.substring(s.indexOf(" ") + 1);
            return firstword.equals(secondword);
        });
        System.out.println("Removed a few names: ");
        newLIst.forEach(System.out::println);


    }
    public static int index(char[] letters) {
        return new Random().nextInt(0, letters.length);
    }
    private static String getReversedName(String firstName) { return new StringBuilder(firstName).reverse().toString(); }
}