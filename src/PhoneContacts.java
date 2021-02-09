import java.util.*;

public class PhoneContacts {
    private Map<String, List<Contact>> phoneContacts;

    public PhoneContacts() {
        phoneContacts = new HashMap<>();
    }

    /**
     * Возвращает мапу
     */
    public Map<String, List<Contact>> getPhoneContacts(String group) {
        if (phoneContacts.containsKey(group)) {
            return phoneContacts;
        } else {
            return null;
        }
    }
    /**
     * Cоздание групп пользователем
     */
    public void addGroup(String groupName) {
        if (!phoneContacts.containsKey(groupName)) {
            phoneContacts.put(groupName, new ArrayList<>());
        }
    }

    /**
     * Создание контакта пользователем
     */
    public void addContact(String groupName, Contact contact) {
        phoneContacts.get(groupName).add(contact);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (String key : phoneContacts.keySet()) {
            sb.append(" - ");
            sb.append(key);
            sb.append(":");
            sb.append("\n");
            for (Contact contact : phoneContacts.get(key)) {
                sb.append(contact);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}





