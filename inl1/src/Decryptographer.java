import se.lth.cs.p.inl1.*;
import se.lth.cs.p.inl1.nbr12.Key;
import se.lth.cs.p.inl1.nbr12.TestCase;
import java.util.ArrayList;

public class Decryptographer {

    private final Key key;
    private final ArrayList<Integer> numbers;
    final int numSize = 5;

    public Decryptographer(Key key) {
        this.key = key;
        int num = key.get5DigitNumber();
        this.numbers = new ArrayList<>();

        while (num > 0) {  //Delar upp keyn i en arraylist av typ Integer
            numbers.add(num % 10);
            num = num / 10;
        }
    }

    public String decrypt(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Character> encryptedCharacters = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) { // delar upp String text i en char arraylist
            encryptedCharacters.add(text.charAt(i));
        }

        int keyPosition = 0;
        for (char c : encryptedCharacters) {
            if (c == ' ') {
                stringBuilder.append(c);
                continue; //om det är mellanslag skippa till nästa iteration av loopen bara
            }
            stringBuilder.append(getDecryptedChar(c, numbers.get(keyPosition % numSize))); //Talet upprepas när den 5e siffran uttnyttjas.
            keyPosition++;
        }
        return stringBuilder.toString();
    }

    /**
     * @param encryptedChar Krypterad bokstav
     * @param keyPosition   1 (första alfabetet) eller 2 (andra alpabetet)
     * @return Den dekrypterade bokstaven.
     */
    private char getDecryptedChar(char encryptedChar, int keyPosition) {
        int position = 0;
        while (key.getLetter(position, keyPosition) != encryptedChar) {
            position++;
        }
        return (char) (position + 'A'); //Ex: position = 5 (index i alpabetet) ger bokstaven F.
    }

    public static void main(String[] args) {
        TextWindow window = new TextWindow("Decryptographer");
        TestCase c = new TestCase();
        Key key = new Key();
        Decryptographer d = new Decryptographer(key);

        TextView cryptoView = new TextView("Kryptotext: ", 2, 150);
        window.addView(cryptoView);
        TextView clearView = new TextView("Min klartext: ", 2, 150);
        window.addView(clearView);
        TextView correctClearView = new TextView("Korrekt klartext: ", 2, 150);
        window.addView(correctClearView);

        for (int i = 1; i <= 5; i++) {
            cryptoView.displayText(c.getCryptoText(i));
            clearView.displayText(d.decrypt(c.getCryptoText(i)));
            correctClearView.displayText(c.getClearText(i));
            window.waitForMouseClick();
        }
    }

}
