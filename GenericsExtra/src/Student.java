import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student implements QueryItem, Comparable<Student> {

    private String name, course;
    private int yearStarted;
    private int id;


    protected static Random random = new Random();

    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] courses = {"Java", "C#", "Python", "PHP"};

    public Student() {
        this.id = random.nextInt(0, 1000);
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)];
        course = courses[random.nextInt(4)];
        yearStarted = random.nextInt(2018, 2025);
    }

    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    public int getId() {
        return id;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch(fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEAR STARTED" -> yearStarted == Integer.parseInt(value);
            default -> false;
        };
    }

    @Override
    public int compareTo(Student o) {
        if (this.yearStarted > o.yearStarted) {
            return 1;
        }
        if (this.yearStarted < o.yearStarted) {
            return -1;
        }
        return 0;
    }
}
