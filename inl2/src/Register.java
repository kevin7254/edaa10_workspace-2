import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Register {
    private ArrayList<Person> reg;

    public Register() {
        this.reg = new ArrayList<>();
    }

    public void addNewPerson(Person person) {
        this.reg.add(person);
        this.reg.sort(Comparator.comparing(Person::getName));
    }

    public void removeAllNames(String name) {
        List<Person> temp = new ArrayList<>();

        for (Person person : this.reg) {
            if (person.getName().toLowerCase().contains(name)) {
                temp.add(person);
            }
        }
        for (Person tempPerson : temp) {
            this.reg.remove(tempPerson);
        }
    }


    public String findAllNames(String name) {
        StringBuilder sb = new StringBuilder();
        for (Person person : this.reg) {
            if (person.getName().toLowerCase().contains(name)) {
                sb.append(person).append("\n");
            }
        }
        return sb.toString();
    }


    public String findAllDates(String date) {
        StringBuilder sb = new StringBuilder();
        for (Person person : this.reg) {
            if (person.getDate().toLowerCase().contains(date)) {
                sb.append(person).append("\n");
            }
        }
        return sb.toString();
    }


    public ArrayList<Person> sortedByDate() {
        this.reg.sort(Comparator.comparing(Person::getDate)); // TODO: 2020-12-02 fix sort by date
        return this.reg;
    }


    public ArrayList<Person> sortedByName() {
        this.reg.sort(Comparator.comparing(Person::getName));
        return this.reg;
    }


    public void readFromFile(String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("Error");
            System.exit(1);
        }
        while (scanner.hasNext()) {
            this.reg.add(new Person(scanner.nextLine(), scanner.nextLine()));
            if (scanner.hasNextLine()) scanner.nextLine();
        }
        this.reg = sortedByName();
    }


    public void writeToFile(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error");
            System.exit(1);
        }
        for (Person person : this.reg) {
            out.println(person);
        }
        out.close();
    }
}
/* Instead of using Comparator
    private void sort() {
        for (int i = 0; i < reg.size() - 1; i++) {
            int lowestVal = i;

            for (int j = i + 1; j < reg.size(); j++) {
                if (reg.get(j).compareTo(reg.get(lowestVal)))
                    lowestVal = j;
            }
            Person temp = reg.get(i);
            reg.set(i, reg.get(lowestVal));
            reg.set(lowestVal, temp);
        }
    } */