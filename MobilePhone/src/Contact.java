public class Contact {
    private String phoneNumber, name;

    private Contact(String name, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getName() {
        return name;
    }
    public static Contact createContact(String phoneNumber, String name) {

        return new Contact(phoneNumber, name);
    }
}
