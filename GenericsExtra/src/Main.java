
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int studentCount = 51;
//        QueryList<LPAStudent> students = new QueryList <>();
//        for (int i = 0; i < studentCount; i++) {
//            students.add(new LPAStudent());
////            students.sort(Comparator.comparingInt(Student::getId)); <-
//        };
//        var matches = students.getMatches("PercentComplete", "50");
//
//        printList(matches);


        QueryList<LPAStudent> lpaStudents = new  QueryList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
//        printList(lpaStudents);

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("PercentComplete", "50")
                .getMatches("Course", "Java");
        printList(matches);
//
//        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
//        printList(students2021);
    }
    public static void printList(List<?> students) {
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
    public static <T extends Student> void sortStudents(List<T> students) {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (students.get(j).getId() > students.get(j+1).getId()) {
                    T temp = students.get(j);
                    students.set(j, students.get(j+1));
                    students.set(j+1, temp);
                }
            }
        }
//        int n = students.size();
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                // Compare students by ID
//                if (students.get(j).getId() > students.get(j + 1).getId()) {
//                    // Swap
//                    Student temp = students.get(j);
//                    students.set(j, students.get(j + 1));
//                    students.set(j + 1, temp);
//                }
//            }
//        }
    }
}