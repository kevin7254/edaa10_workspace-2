
public class Person {
    private final String name;
    private final String date; //Ex: 760410

    public Person(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return name + "\t " + date;
    }


    public boolean compareTo(Person person) {
        return name.compareTo(person.getName()) < 0;
    }
}
