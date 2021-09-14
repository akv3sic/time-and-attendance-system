package app.helpers;

public class Email {
    String eMailAddress;

    public Email(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public Email() {
    }

    public boolean isValid(String address) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return address.matches(regex);
    }
}
