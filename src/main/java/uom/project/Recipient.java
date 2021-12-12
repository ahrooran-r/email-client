package uom.project;

abstract class Recipient {

    private final String name;
    private final String email;
    private static int recipientObjectCounter = 0;

    // set details for fields
    public Recipient(String name, String email) {
        name = name.trim();
        email = email.trim();

        if (isAlpha(name)) this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        else this.name = "null";
        if (isEmail(email)) this.email = email;
        else this.email = "null";

        recipientObjectCounter += 1;
    }

    // get details
    public final String getName() {
        return this.name;
    }

    public final String getEmail() {
        return this.email;
    }

    // get number of recipient object
    public static int getCounter() {
        return recipientObjectCounter;
    }

    // check validity of name
    public static boolean isAlpha(String name) {

        name = name.toLowerCase();

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ' && name.charAt(i) >= 'a' && name.charAt(i) <= 'z') {
            } else return false;
        }

        return true;
    }

    // check validity of email
    public static boolean isEmail(String email) {
        int counterAt = 0;
        int counterDot = 0;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == ' ') return false;
            else if (email.charAt(i) == '@') counterAt += 1;
            else if (email.charAt(i) == '.') counterDot += 1;
        }

        return counterAt == 1 && counterDot >= 1;
    }
}
