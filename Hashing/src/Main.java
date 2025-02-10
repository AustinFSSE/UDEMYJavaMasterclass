import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

//        String aText = "Hello";
//        String bText = "Hello";
//        String cText = String.join("l", "He", "lo");
//        String dText = "He".concat("llo");
//        String eText = "hello";
//
//        List <String> hellos = Arrays.asList(aText, bText, cText, dText, eText);
//
//        hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));
//
//        Set <String> myHashSet = new HashSet <>(hellos);
//        System.out.println(myHashSet + " " + myHashSet.size());
//
//        for (String s : myHashSet) {
//            System.out.print(s + ": ");
//            for (int i = 0; i < hellos.size(); i++) {
//                if (s == hellos.get(i)) {
//                    System.out.print(i + ", ");
//                }
//            }
//            System.out.println();
//        }
        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard jackSpade = new PlayingCard("Spades", "Jack");
        PlayingCard queenDiamond = new PlayingCard("Diamonds", "Queen");


        List<PlayingCard> cards = Arrays.asList(aceHearts, jackSpade, queenDiamond);
        cards.forEach(c -> System.out.println(c.toString() + c.hashCode()));

        Set<PlayingCard> deck = new HashSet<>();
        for (PlayingCard c : cards) {
            if (!deck.add(c)) {
                System.out.println("Found a duplicate for " + c);
            }
        }
        System.out.println(deck);
    }
}