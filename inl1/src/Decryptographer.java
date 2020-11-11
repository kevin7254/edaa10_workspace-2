import org.jetbrains.annotations.NotNull;
import se.lth.cs.p.inl1.*;
import se.lth.cs.p.inl1.nbr12.Key;
import se.lth.cs.p.inl1.nbr12.TestCase;

import java.util.ArrayList;

public class Decryptographer {

    private final Key key;
    private final ArrayList<Integer> numbers;
    private final int numSize;

    public Decryptographer(Key key) {
        this.key = key;
        int num = key.get5DigitNumber();
        this.numSize = (int)(Math.log10(num)+1);
        this.numbers = new ArrayList<>();

        while (num > 0) {  //Delar upp keyn i en arraylist av typ Integer
            numbers.add(num % 10);
            num = num / 10;
        }
    }

    public String decrypt(@NotNull String text) {
        StringBuilder stringBuilder = new StringBuilder();

        int keyPosition = 0;
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                stringBuilder.append(getDecryptedChar(c, numbers.get(keyPosition % numSize))); //index 0,1,2,3,4,0,1,2,3,4...
                keyPosition++;
            } else {
                stringBuilder.append(c);
            }
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
