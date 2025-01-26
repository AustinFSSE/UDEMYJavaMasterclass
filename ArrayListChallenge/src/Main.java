
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<String> groceryList = new ArrayList<>();

    private static void addItems() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your list items your would like to add to your grocery list. Separate each item with a comma");
        String[] items = scanner.nextLine().split(",");
        for (String item : items) {
            item = item.trim();
            if (!groceryList.contains(item)) {
                groceryList.add(item);
            }
        }
        groceryList.sort(Comparator.naturalOrder());
        display();
    }
    private static void removeItems() {
        if (groceryList.isEmpty()) {
            System.out.println("You have no items to remove.");
            return;
        }
        display();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which item would you like to remove?");
        String item = scanner.nextLine();
        groceryList.remove(item);
        groceryList.sort(Comparator.naturalOrder());
        display();
    }

    private static void display() {
        System.out.println(groceryList);
    }
    private static void displayActions(){
        System.out.println("Available actions:");
        System.out.print("""
                    0 - to shutdown
                    1 - to add item(s) to list (comma delimited list)
                    2 - to remove item(s) from list (comma delimited list)
                    Enter a number for which action you want to do:
                    """);
    }

    public static void main(String[] args) {
        while (true) {
            displayActions();
            Scanner scanner = new Scanner(System.in);
            int action = scanner.nextInt();
            switch (action) {
                case 0 -> System.exit(0);
                case 1 -> addItems();
                case 2 -> removeItems();
                default -> System.out.println("Invalid action");
            }

        }
    }
}