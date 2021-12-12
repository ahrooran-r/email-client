package uom.project;

import java.io.*;

class Format {

    public static String[] traverseDatabaseDetails(String input) {

        input = input.trim();
        String firstWord = input.substring(0, input.indexOf(':')).toLowerCase();

        String[] data = input.substring(input.indexOf(':') + 1).split(",");
        for (int i = 0; i < data.length; i++) data[i] = data[i].trim();

        String category, name, nickname, email, designation, birthday;

        switch (firstWord) {
            case "official":
                // Official: nimal,nimal@gmail.com,ceo
                // data = [0-name, 1-email, 2-designation]
                category = firstWord;
                name = data[0];
                nickname = "null";
                email = data[1];
                designation = data[2];
                birthday = "null";
                break;

            case "office_friend":
                // Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12
                // data = [0-name, 1-email, 2-designation, 3-birthday]
                category = firstWord;
                name = data[0];
                nickname = "null";
                email = data[1];
                designation = data[2];
                birthday = data[3];
                break;

            case "personal":
                // Personal: sunil,<nick-name>,sunil@gmail.com,2000/10/10
                // data = [0-name, 1-nickname, 2-email, 3-birthday]
                category = firstWord;
                name = data[0];
                nickname = data[1];
                email = data[2];
                designation = "null";
                birthday = data[3];
                break;

            default:
                category = "null";
                name = "null";
                nickname = "null";
                email = "null";
                designation = "null";
                birthday = "null";
        }

        String[] details = {category, name, nickname, email, designation, birthday};
        return details;
    }

    public static void updateFile(String category, String name, String nickname, String email, String designation, String birthday, String filePath) {
        category = category.toLowerCase();
        String outputString = "";

        String substring = category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase();

        switch (category) {
            case "official":
                outputString = String.format("%s: %s, %s, %s", substring, name, email, designation);
                break;
            case "personal":
                outputString = String.format("%s: %s, %s, %s, %s", substring, name, nickname, email, birthday);
                break;
            case "office_friend":
                outputString = String.format("%s: %s, %s, %s, %s", substring, name, email, designation, birthday);
                break;
        }

        try {
            FileWriter file = new FileWriter(filePath, true);
            BufferedWriter update = new BufferedWriter(file);
            update.write(outputString);
            update.newLine();
            update.close();

        } catch (Exception ignored) {
        }
    }

    static String[] detailArray;

    private static void readFile(String filePath) {
        try {

            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }

            fileReader.close();
            detailArray = stringBuilder.toString().split("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getDetailArray(String filePath) {
        readFile(filePath);
        return detailArray;
    }
}
