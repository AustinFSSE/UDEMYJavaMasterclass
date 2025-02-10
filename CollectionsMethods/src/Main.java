import java.util.*;

public class Main {
    public static void main(String[] args) {


//        Card[] cardArray = new Card[13];
//        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
//        Arrays.fill(cardArray, aceOfHearts);
//        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);
//
//        List<Card> cards = new ArrayList <>(52);
//        Collections.fill(cards, aceOfHearts);
//        System.out.println(cards);
//        System.out.println(cards.indexOf(aceOfHearts));
//
//        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
//        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);
//
//        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
//        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
//        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);
//
//        Collections.addAll(cards, cardArray);
//        Collections.addAll(cards, cardArray);
//        Card.printDeck(cards, "Card Collection with Aces added", 2);
//
//        Collections.copy(cards, kingsOfClubs);
//        Card.printDeck(cards, "Card collection wiht Kings copied", 2);
//
//        List <Card> deck = Card.getStandardDeck();
//        Card.printDeck(deck);
//
////        Collections.shuffle(deck);
////        Card.printDeck(deck, "Deck shuffled", 4);
//
////        Collections.reverse(deck);
////        Card.printDeck(deck, "Deck reversed", 4);
//        var sortingAlgo = Comparator.comparing(Card::rank).thenComparing(Card::suit);
//        Collections.sort(deck, sortingAlgo);
//        Card.printDeck(deck);
//
//        Collections.reverse(deck);
//        Card.printDeck(deck, "Deck reversed", 13);

        List<Card> firstPlayer = Card.generateHand(Card.getStandardDeck());
        List<Card> secondPlayer = Card.generateHand(Card.getStandardDeck());
        Card.printDeck(firstPlayer, "first player", 1);
        Card.printDeck(secondPlayer, "second player", 1);
    }
}