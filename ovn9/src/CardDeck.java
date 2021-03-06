import java.util.Random;

public class CardDeck {

    private final Card[] cards;
    private static final int DECK_SIZE = 52;
    private int cardPos;

    public CardDeck() {
        this.cards = new Card[DECK_SIZE];
        this.cardPos = DECK_SIZE - 1;

        int i = 0;
        for (int value = 1; value <= 13; ++value) {
            for (int suit = Card.SPADES; suit <= Card.CLUBS; ++suit) {
                cards[i++] = new Card(suit, value);
            }
        }
    }

    void shuffle() {
        this.cardPos = DECK_SIZE - 1;
        Random rand = new Random();

        for (int i = 0; i < DECK_SIZE; i++) {
            Card cardTemp = cards[i];

            int arrIndex = rand.nextInt(DECK_SIZE - 1);
            cards[i] = cards[arrIndex];

            cards[arrIndex] = cardTemp;

        }
    }

    boolean moreCards() {
        return cardPos >= 0;
    }

    Card getCard() {

        if (!moreCards()) {
            return null;
        }

        return cards[cardPos--];
    }

}
