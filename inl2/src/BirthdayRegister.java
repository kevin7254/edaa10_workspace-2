
public class BirthdayRegister {

    public static void main(String[] args) {
        Dialog dialog = new Dialog();
        Register register = new Register();

        final String FILE_NAME = "inl2/src/savefile.txt";

        while (true) {
            int commmand = dialog.readInt(" 1. Import name \n 2. Remove name \n 3. Search when x was born \n 4. Search" +
                    " for birthdate \n 5. List all persons after name \n 6. List all persons after birthdate \n 7. Save" +
                    " register to file \n 8. Load register from file");

            switch (commmand) {
                case 1 -> register.addNewPerson(new Person(dialog.readString("Enter name"),
                        dialog.readString("Enter birthday")));
                case 2 -> register.removeAllNames(dialog.readString("Remove all with the following name: "));
                case 3 -> dialog.printString(register.findAllNames(dialog.
                        readString("Show when person x was born: ")));
                case 4 -> dialog.printString(register.findAllDates(dialog.
                        readString("Show all persons with the following birthdate: ")));
                case 5 -> dialog.printString(register.sortedByName().toString());
                case 6 -> dialog.printString(register.sortedByDate().toString());
                case 7 -> register.writeToFile(FILE_NAME);
                case 8 -> register.readFromFile(FILE_NAME);
                default -> System.exit(1);
            }
        }
    }
}
