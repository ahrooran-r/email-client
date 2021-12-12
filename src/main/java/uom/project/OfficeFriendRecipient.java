package uom.project;

import java.io.Serializable;
import java.util.Arrays;

final class OfficeFriendRecipient extends OfficialRecipient implements IBirthday, Serializable {

    private final int[] birthday = new int[3];

    public OfficeFriendRecipient(String name, String email, String designation, String birthday) {

        super(name, email, designation);
        // convertBirthday ();
        arrangeBirthday(birthday); // if birthday has errors: birthday = [-1, -1, -1]
    }

    public String getBirthday() {

        if (!Arrays.toString(this.birthday).equals("[-1,-1,-1]")) {
            String stringMonth = this.birthday[1] < 10 ? "0" + this.birthday[1] : Integer.toString(this.birthday[1]);
            String stringDay = this.birthday[2] < 10 ? "0" + this.birthday[2] : Integer.toString(this.birthday[2]);
            return String.format("%s/%s", stringMonth, stringDay); // birthday is in string form

        } else {
            return "null";
        }
    }

    public String getFullBirthday() {

        if (!Arrays.toString(this.birthday).equals("[-1,-1,-1]")) {
            String stringYear = Integer.toString(this.birthday[0]);
            String stringMonth = this.birthday[1] < 10 ? "0" + this.birthday[1] : Integer.toString(this.birthday[1]);
            String stringDay = this.birthday[2] < 10 ? "0" + this.birthday[2] : Integer.toString(this.birthday[2]);
            return String.format("%s/%s/%s", stringYear, stringMonth, stringDay); // birthday is in string form

        } else {
            return "null";
        }
    }

    //arrange birthday in order
    private void arrangeBirthday(String birthday) {
        String[] birthdayTrim = birthday.trim().split("/");

        try {
            if (birthdayTrim.length != 3) throw new Exception();

            for (int i = 0; i < birthdayTrim.length; i++) {

                int temp = Integer.parseInt(birthdayTrim[i]);

                switch (i) {
                    case 0:
                        this.birthday[i] = (temp >= 1895 && temp <= 2005) ? temp : -1;
                        break;
                    case 1:
                        this.birthday[i] = (temp >= 1 && temp <= 12) ? temp : -1;
                        break;
                    case 2:
                        this.birthday[i] = (temp >= 1 && temp <= 31) ? temp : -1;
                        break;
                    default:
                        throw new NumberFormatException();
                }
            }

        } catch (Exception e) {
            Arrays.fill(this.birthday, -1);
        }
    }
}
