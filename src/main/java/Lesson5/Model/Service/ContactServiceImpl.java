package Lesson5.Model.Service;

import Lesson5.Model.Contact.Contact;
import Lesson5.Model.Contact.Phone;
import Lesson5.Model.Contact.User;

import java.util.ArrayList;

public class ContactServiceImpl implements ContactService<User, Phone> {


    @Override
    public boolean isCorrect(User user, ArrayList<Phone> phones) {
        boolean isCorrect = true;
        if (user.getFirstName().contains("\\W") || user.getLastName().contains("\\W")) {
            isCorrect = false;
        }
        for (Phone phone : phones) {
            try {
                Integer.parseInt(phone.getPhoneNumber());
            } catch (NumberFormatException e) {
                isCorrect = false;
            }
        }
        return isCorrect;
    }

    @Override
    public Contact createContact(User user, ArrayList<Phone> phones) {
        if (this.isCorrect(user, phones)) {
            Contact contact = new Contact(user);
            for (Phone i : phones) {
                contact.addPhone(i);
            }
            return contact;
        }
        return null;
    }
}