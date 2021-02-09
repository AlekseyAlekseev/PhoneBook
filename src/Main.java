import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Contact contact;
        String[] fullName;
        PhoneContacts phoneContacts = new PhoneContacts();
        Scanner scanner = new Scanner(System.in);

        /**
         * Вывод на экран статичного текста
         */
        StaticText.getStaticText();

        /**
         *  Создание групп
         */
        String input = scanner.nextLine();
        phoneContacts.addGroup(input);
        while (true) {
            System.out.println("Создать еще одну группу (введите название или введите \"нет\")?");
            input = scanner.nextLine();
            if (input.equals("нет")) {
                break;
            } else if (phoneContacts.getPhoneContacts(input) != null) {
                System.out.println("Такая группа уже существует! Повторите ввод.");
            } else {
                phoneContacts.addGroup(input);
            }

        }
        /**
         *  Cоздание контакта
         */
        while (true) {
            System.out.println("Создать контакт (введите наименование и его номер или введите нет)?");
            input = scanner.nextLine();
            if (input.equals("нет")) {
                break;
            }
            contact = new Contact();
            fullName = input.split(" ");
            if (fullName.length != 3) {
                System.out.println("Введите пожалуйста в формате:");
                System.out.println("Имя Фамилия Номер_телефона");
                continue;
            }
            contact.setName(fullName[0]);
            contact.setLastName(fullName[1]);
            contact.setPhoneNumber(fullName[2]);
            System.out.println("Укажите группы контакта через пробел");
            input = scanner.nextLine();
            for (String group : input.split(" ")) {
                if (phoneContacts.getPhoneContacts(group) != null) {
                    phoneContacts.addContact(group, contact);
                    System.out.println("Контакт добавлен!");
                } else {
                    System.out.println("Контакт не добавлен в группу - " + group +
                            ", введенной группы не существует");
                }
            }
        }

        /**
         * Вывод на экран
         */
        System.out.println(phoneContacts);
        scanner.close();
    }
}
