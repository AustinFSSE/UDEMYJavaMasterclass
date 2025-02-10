import java.util.*;

public class Main {
    public static void main(String[] args) {
        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);

        Set <Task> tasks = TaskData.getTasks("all");

        sortAndPrint("All Tasks", tasks, sortByPriority);



        Set <Task> annsTasks = TaskData.getTasks("ann");
        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);

        Set<Task> bobsTasks = TaskData.getTasks("bob");
        Set<Task> carolsTasks = TaskData.getTasks("carol");
        List<Set<Task>> sets = List.of(annsTasks, bobsTasks, carolsTasks);

        Set<Task> assignedTasks = getUnion(bobsTasks, carolsTasks, annsTasks);
        sortAndPrint("Assigned Tasks", assignedTasks);

        Set<Task> everyTask = getUnion(assignedTasks, tasks);
        sortAndPrint("Every Task", everyTask);

        Set<Task> missingTasks = getDifference(everyTask, tasks);
        sortAndPrint("Missing Tasks", missingTasks);

        Set<Task> unassignedTasks = getDifference(tasks, assignedTasks);
        sortAndPrint("Unassigned Tasks", unassignedTasks, sortByPriority);

        Set<Task> overLap = getUnion(
                getIntersection(annsTasks, bobsTasks),
                getIntersection(carolsTasks, bobsTasks),
                getIntersection(annsTasks, carolsTasks));

        sortAndPrint("Overlap Tasks", overLap, sortByPriority);

        List<Task> overLapping = new ArrayList<>();
        for (Set<Task> set : sets) {
            Set<Task> dupes = getIntersection(set, overLap);
            overLapping.addAll(dupes);
        }
        Comparator<Task> priorityNatural = sortByPriority.thenComparing(Comparator.naturalOrder());

        sortAndPrint("Overlapping", overLapping, priorityNatural);

    }

    private static void sortAndPrint(String header, Collection<Task> collections) {
        sortAndPrint(header, collections, null);
    }

    private static void sortAndPrint(String header, Collection <Task> collections, Comparator <Task> sorter) {

        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List <Task> list =  new ArrayList <>(collections);
        list.sort(sorter);
        list.forEach(System.out::println);

    }

    @SafeVarargs
    private static Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> set : sets) {
            union.addAll(set);
        }
        return union;
    }
    private static Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }
    private static Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }
}