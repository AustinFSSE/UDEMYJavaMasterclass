import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Person(String fName, String lName) {}

    static List<Person> people = new ArrayList <>(List.of(
            new Person("Austin", "Martin"),
            new Person("Adam", "Snider"),
            new Person("Bob", "Smith")
    ));


    interface EnhancedComparator<T> extends Comparator<T> {
        int secondLevel(T o1, T o2);
    }

    public static void main(String[] args) {

        System.out.println("Hello, World!");

        // Before lambdas were introduced
        var comparatorLName = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lName.compareTo(o2.lName);
            }
        };
        System.out.println(comparatorLName);
        // Full Lambda expression
        people.sort((o1, o2) -> o1.lName().compareTo(o2.lName()));
        System.out.println(people);
        // More modern approach.
        // First entry is the object::specific field within that object that will be used for comparison
        people.sort(Comparator.comparing(Person::lName)); // Modern version
        System.out.println(people);

        var comparatorMixed = new EnhancedComparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lName().compareTo(o2.lName());
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.fName().compareTo(o2.fName());
            }
        };
        people.sort(comparatorMixed);
        System.out.println(people);


    }
}