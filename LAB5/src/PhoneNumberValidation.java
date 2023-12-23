import java.util.regex.*;

public class PhoneNumberValidation {
    public static void main(String[] args) {
        String phoneNumber = "(+380)50-333-33-33";
        String regex = "^\\(\\+380\\)\\d{2}-\\d{3}-\\d{2}-\\d{2}$";

        boolean isValid = Pattern.matches(regex, phoneNumber);
        System.out.println("Phone number is valid: " + isValid);
    }
}