public class Patience {

    CardDeck deck;
    private static double numberOfTries = 1;
    private static double timesWon = 0;

    public Patience(int numberOfRuns) {
        int i = 1;
        while (i++ < numberOfRuns) {
            this.deck = new CardDeck();
            deck.shuffle();
            numberOfTries++;
            if (!isLosing()) {
                timesWon++;
            }
        }
    }


    private boolean isLosing() {
        int count = 1;
        while (deck.moreCards()) {

            if (count > 3) {
                count = 1;
            }

            if (deck.getCard().getRank() == count) {
                return true;
            }
            count++;
        }
        return false;
    }

    public static void main(String[] args) {
        new Patience(300000);
        System.out.println(Patience.timesWon);
        System.out.println("Sannolikhet för att patiensen ska gå ut: " + Patience.timesWon / Patience.numberOfTries);
    }

}
