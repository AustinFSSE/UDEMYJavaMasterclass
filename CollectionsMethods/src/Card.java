import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public record Card(Suit suit, String face, int rank) {

    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;
        public char getImage() {
            return (new char[]{9827,9830,9829,9824})[this.ordinal()];
        }

    }
    public enum WinningHands {
        HIGHEST_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH;
    }

    @Override
    public String toString() {
        int index = face.equals("10") ? 2 : 1;
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }
    public static Card getNumericCard(Suit suit, int cardNumber) {
        if (cardNumber > 1 && cardNumber < 11) {
            return new Card(suit, String.valueOf(cardNumber), cardNumber -2);
        }
        System.out.println("Invalid Numeric card selected");
        return null;
    }
    public static Card getFaceCard(Suit suit, char abbrev) {
        int charIndex = "JQKA".indexOf(abbrev);
        if (charIndex > -1) {
            return new Card(suit, "" + abbrev, charIndex + 9);
        }
        System.out.println("Invalid Face card selected");
        return null;
    }
    public static List <Card> getStandardDeck() {
        List<Card> deck = new ArrayList <Card>(52);
        for (Suit suit : Suit.values()) {
            for (int i = 2; i <= 10; i++) {
                deck.add(getNumericCard(suit, i));
            }
            for (char c : new char[]{'J','Q','K','A'}) {
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }
    public static void printDeck(List<Card> deck, String description, int rows) {
        System.out.println("-".repeat( 20));
        if (description != null) {
            System.out.println(description);
        }
        int cardsInRow = deck.size()/rows;
        for (int i = 0; i < rows; i++) {
            int startIndex = i*cardsInRow;
            int endIndex = i*cardsInRow + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

    public static List<Card> generateHand(List<Card> deck) {
        List<Card> hand = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            hand.add(deck.get(new Random().nextInt(0, deck.size())));
        }
        return hand;
    }
    public static int evaluateHand(List<Card> hand) {
        int value = 0;

        int j = 1;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).equals(hand.get(j)) ) {
                value = WinningHands.PAIR.ordinal();
                return value;
            }
        }
        return 0;
    }

    public static void printHand(List<Card> hand) {
        System.out.println("-".repeat( 20));
        printDeck(hand, "First Player", 1);
    }
    public static void printDeck(List<Card> deck) {
        printDeck(deck, "Current Deck", 4);
    }
}
