import java.util.ArrayList;


public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<Contact>();
    }
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }
    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (!myContacts.contains(oldContact)) {
            System.out.println("Contact does not exist.");
            return false;
        }
        myContacts.set(myContacts.indexOf(oldContact), newContact);
        return true;
    }
    public boolean removeContact(Contact contact) {
        if (!myContacts.contains(contact)) {
            System.out.println("Contact does not exist.");
            return false;
        }
        myContacts.remove(contact);
        return true;
    }

    private int findContact(Contact contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).equals(contact)) {
                return i;
            }
        }
        return -1;
    }
    private int findContact(String info) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(info)) {
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String info) {
        for (Contact myContact : myContacts) {
            if (myContact.getName().equals(info)) {
                return myContact;
            }
        }
        return null;
    }
    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i+1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}

