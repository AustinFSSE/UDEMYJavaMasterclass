import java.util.*;

public class MapViewsMain {

    public static void main(String[] args) {

        Map <String, Contact> contacts = new HashMap <>();
        ContactData.getData("phones").forEach(contact -> contacts.put(contact.getName(), contact));
        ContactData.getData("emails").forEach(contact -> contacts.put(contact.getName(), contact));

        Set <String> keysView = contacts.keySet();
//        System.out.println(keysView);
//
        Set<String> copyOfKeys = new TreeSet <>(contacts.keySet());
//        System.out.println(copyOfKeys);
//
//        if (contacts.containsKey("Linus Van Pelt")) {
//            System.out.println("FOUND LINUS");
//        }
//
//        keysView.remove("Daffy Duck");
//        System.out.println(keysView);
//        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));
//
//        copyOfKeys.remove("Linus Van Pelt");
//        System.out.println(keysView);
//        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));
//
//        keysView.retainAll(List.of("Linus Van Pelt", "Charlie Brown",
//                "Robin Hood", "MickeyMouse"));
//        System.out.println(keysView);
//        contacts.forEach((k, v) -> System.out.println(v));

        keysView.clear();
        System.out.println(keysView);

        ContactData.getData("phones").forEach(contact -> contacts.put(contact.getName(), contact));
        ContactData.getData("emails").forEach(contact -> contacts.put(contact.getName(), contact));
        System.out.println(keysView);

        var values = contacts.values();
        values.forEach(System.out::println);

        values.retainAll(ContactData.getData("emails"));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

    }
}
