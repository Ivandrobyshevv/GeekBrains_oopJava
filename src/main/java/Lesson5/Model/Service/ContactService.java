package Lesson5.Model.Service;

import Lesson5.Model.Contact.Contact;
import Lesson5.Model.Contact.Phone;
import Lesson5.Model.Contact.User;

import java.util.ArrayList;

public interface ContactService <T extends User, E extends Phone>  {

    public boolean isCorrect(T user, ArrayList<E> phones);
    public Contact createContact(T user, ArrayList<E> phones);

}