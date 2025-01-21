import java.util.LinkedList;
import java.util.ListIterator;

public class LinkyLIsts {

    public static void main(String[] args) {

      LinkedList<String> placesToVisit = new LinkedList<>();
//        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Melbourne");

        addMoreElements(placesToVisit);
//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);
//        gettingElements(placesToVisit);
        System.out.println();
        getItinerary2(placesToVisit);

    }

    private static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Indiana");
        list.addLast("Hobart");
        // Queue methods
        list.offerFirst("Kentucky");
        list.offer("Georgia");
        list.offer("Illinois");
        // Stack Methods
        list.push("California");
    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Melbourne");

        System.out.println(list);
        String s1 = list.remove();// removes first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst(); // removes first element
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast(); // removes last element
        System.out.println(s3 + " was removed");

        // Queue/Deque poll methods
        String p1 = list.poll();
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast();
        System.out.println(p3 + " was removed");

    }

    private static void gettingElements(LinkedList<String> list) {
        System.out.println("Retrieving elements by list.get(index): " + list.get(4)); // returns value and not index
        System.out.println("Retrieving elements by list.getLast(): " + list.getLast()); // returns value and not index
        System.out.println("Retrieving elements by list.getFirst(): " + list.getFirst()); // return value and not index
        System.out.println("Retrieving elements by list.lastIndexOf(): " + list.lastIndexOf("Hobart")); // returns index
        // Queue retrieval method
        System.out.println("Retrieving elements by Queue.element(): " + list.element()); // first element
        // Stack retrieval methods
        System.out.println("Retrieving elements by Stack.peek(): " + list.peek()); // first element
        System.out.println("Retrieving elements by Stack.peekFirst(): " + list.peekFirst()); // first element
        System.out.println("Retrieving elements by Stack.peekLast(): " + list.peekLast());
    }
    private static void getItinerary(LinkedList<String> list) {
        String previousPlace = list.getFirst();
        for (String place : list) {
            System.out.println(" ---> From: " + previousPlace + " -> " + place);
            previousPlace = place;
        }
        System.out.println("Trip ends at " + list.getLast());
    }
    private static void getItinerary2(LinkedList<String> list) {

        System.out.println("Trip starts at " + list.getFirst());
        String previousPlace = list.getFirst();
        ListIterator <String> listIterator = list.listIterator(1);
        while (listIterator.hasNext()) {
            var town = listIterator.next();
            System.out.println("---> From: " + previousPlace + " -> " + town);
            previousPlace = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }
}
