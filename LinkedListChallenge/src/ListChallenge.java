import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class ListChallenge {

    public ListChallenge() {}

    private static void forwardPass(LinkedList<Places> locations) {
        ListIterator<Places> iterator = locations.listIterator(1);
        String firstPlace = locations.getFirst().getTown();
        while (iterator.hasNext()) {
            Places place = iterator.next();
            System.out.println("---> From: " + firstPlace + " -> " + place.getTown());
            firstPlace = place.getTown();
        }
    }
    private static void backwardPass(LinkedList<Places> locations) {
        ListIterator<Places> iterator = locations.listIterator(locations.size() - 1);// the "-1" prevents a double printout in the println statement
        String lastPlace = locations.getLast().getTown();
        while (iterator.hasPrevious()) {
            Places place = iterator.previous();
            System.out.println("---> From: " + lastPlace + " -> " + place.getTown());
            lastPlace = place.getTown();
        }
    }
    private static void organize(LinkedList<Places> locations) {
        boolean flag = true;
        while (flag && !locations.isEmpty()) {
            flag = false;
            for(int i = 0; i < locations.size()-1; i++) {
                if (locations.get(i).getDistance() > locations.get(i + 1).getDistance()) {
                    var temp = locations.get(i);
                    locations.set(i, locations.get(i+1));
                    locations.set(i+1, temp);
                    flag = true;
                }
            }
        }
    }
    private static void printList(LinkedList<Places> locations) {
        organize(locations);
        for (var place : locations) {
            System.out.println(place.getTown());
        }
    }
    private static void displayMenu() {
        System.out.println("""
                Available Actions (select word or letter)
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }

    public static void main(String[] args) {
        LinkedList<Places> locations = new LinkedList<>();
        locations.add(new Places("Adelaide", 699));
        locations.add(new Places("Alice Springs", 701));
        locations.add(new Places("Bob Bob", 700));
        displayMenu();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Enter action: ");
            char input = scanner.next().charAt(0);
            char choice = Character.toUpperCase(input);
            switch (choice) {
                case 'F' -> forwardPass(locations);
                case 'B' -> backwardPass(locations);
                case 'L' -> printList(locations);
                case 'M' -> displayMenu();
                case 'Q' -> System.exit(0);
            }
        }


    }
}
