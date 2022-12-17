package Lesson5.Model.Contact;

import java.util.ArrayList;
import java.util.Objects;

public class Contact {
    private User user;
    private ArrayList<Phone> phones;

    public Contact(User user) {
        this.user = user;
        phones = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return Objects.equals(user, contact.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, phones);
    }

    public void addPhone(Phone phone){
        this.phones.add(phone);
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("{User:" + user + ", phones:[");
        for (int i = 0; i< this.phones.size(); i++){
            message.append("phoneNumber "+ String.valueOf(i+1) + ": " + this.phones.get(i) + ",");
        }
        message.append("]");
        return message.toString();
    }
}
