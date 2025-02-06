import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Employee(String firstName, String lastName, String hireDate) { }

    public static void printOrderedList(List<Employee> employees, String sortField) {

        class InnerEmployees implements Comparable<InnerEmployees> {

            private Employee employee;
            private String fullname;
            private int yearsWorked;

            public InnerEmployees(Employee employee) {
                this.employee = employee;
                this.yearsWorked = getYearsWorked(employee);
                this.fullname = getFullName(employee);
            }
            private String getFullName(Employee employee) {
                return employee.firstName + " " + employee.lastName;
            }
            private int getYearsWorked(Employee employee) {
                String[] words = employee.hireDate.split("/");
                String year = words[2];
                int currentYear = LocalDate.now().getYear();
                return currentYear - Integer.parseInt(year);
            }

            @Override
            public int compareTo(InnerEmployees o) {
                return this.getFullName(employee).compareTo(o.getFullName(employee));
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years"
                        .formatted(getFullName(employee), getYearsWorked(employee));

            }
        }
        List<InnerEmployees> innerEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            innerEmployees.add(new InnerEmployees(employee));
        }
        var comparator = new Comparator <InnerEmployees>() {
            @Override
            public int compare(InnerEmployees o1, InnerEmployees o2) {
                if (sortField.equals("name")) {
                    return o1.fullname.compareTo(o2.fullname);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };
        innerEmployees.sort(comparator);
        for (InnerEmployees inner : innerEmployees) {
            System.out.println(inner.toString());
        }

    }
    public static void main(String[] args) {

        List <Employee> employees = new ArrayList <>(List.of(
                new Employee("Bob", "Martin", "01/01/1897"),
                new Employee("Janus", "Bertha", "12/31/1985")
        ));
        printOrderedList(employees, "name");
        System.out.println();
        printOrderedList(employees, "firstName");

    }


}