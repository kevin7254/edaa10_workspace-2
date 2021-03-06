
public class Card {
	public static final int SPADES = 1;
	public static final int HEARTS = SPADES + 1;
	public static final int DIAMONDS = SPADES + 2;
	public static final int CLUBS = SPADES + 3;
	private int rank;	// val�r
	private int suit;   // f�rg
	
	/** Skapar ett spelkort med f�rgen suit (SPADES, HEARTS, DIAMONDS, CLUBS) 
	    och val�ren rank (1-13) */
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/** Tar reda p� f�rgen */
	public int getSuit() {
		return suit;
	}

	/** Tar reda p� val�ren */
	public int getRank() {
		return rank;
	}

	/** Returnerar en l�sbar representation av kortet, t ex "spader ess" */
	public String toString(){
		String suitString = switch (suit) {
			case SPADES -> "spader";
			case HEARTS -> "hjärter";
			case DIAMONDS -> "ruter";
			case CLUBS -> "klöver";
			default -> "";
		};
		String rankString = switch (rank) {
			case 1 -> "ess";
			case 11 -> "knekt";
			case 12 -> "dam";
			case 13 -> "kung";
			default -> String.valueOf(rank);
		};
		return suitString + " " + rankString;
	}
}