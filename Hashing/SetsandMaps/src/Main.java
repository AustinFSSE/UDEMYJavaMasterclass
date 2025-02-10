import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List <Contact> emails = ContactData.getData("emails");
        List <Contact> phones = ContactData.getData("phones");
//        printData("Phones : ", phones);
//        printData("Emails : ", emails);

        Set <Contact> emailContacts = new HashSet <>(emails);
        Set <Contact> phoneContacts = new HashSet<>(phones);
        printData("Phones : ", phoneContacts);
        printData("Emails : ", emailContacts);


    }
    public static void printData(String header, Collection <Contact> contacts) {
        System.out.println(".".repeat(20));
        System.out.println(header);
        System.out.println(".".repeat(20));
        contacts.forEach(System.out::println);
    }
}