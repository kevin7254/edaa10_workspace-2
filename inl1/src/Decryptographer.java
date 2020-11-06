import se.lth.cs.p.inl1.*;
import se.lth.cs.p.inl1.nbr12.Key;
import se.lth.cs.p.inl1.nbr12.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decryptographer {

    Key key;

    public Decryptographer(Key key) {
        this.key = key;
    }


    public String decrypt(String text) {

        int num = key.get5DigitNumber();
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> indexCheck = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0;i<text.length(); i++) {
            characters.add(text.charAt(i));
        }


        for (char s : characters) {
            indexCheck.add(s - 'A');
        }

        while (num > 0) {  //Delar upp keyn i en arraylist av typ Integer

            numbers.add(num % 10);

            num = num / 10;
        }

        int i = 0;
        for (int numb : numbers) {
            System.out.println(indexCheck);
                System.out.println(key.getLetter(indexCheck.get(i),numb));
                i++;
        }

        return text;
    }


    public static void main(String[] args) {

        TextWindow window = new TextWindow("Title");
        TextView view = new TextView("Test", 50, 150);
        TestCase case1 = new TestCase();
        Key key = new Key();

        window.addView(view);

        view.displayText(case1.getCryptoText(1));

        Decryptographer decrypt1 = new Decryptographer(key);

        decrypt1.decrypt(case1.getCryptoText(1));


    }


}
