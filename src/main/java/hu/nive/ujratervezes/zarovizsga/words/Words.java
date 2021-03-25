package hu.nive.ujratervezes.zarovizsga.words;

public class Words {
    public boolean hasMoreDigits(String input) {
        int numberOfNumbers = 0;
        int numberOfOthers = 0;

        for (int i = 0; i < input.length(); i++) {
            char[] characters = input.toCharArray();
            if (Character.isDigit(characters[i])) {
                numberOfNumbers++;
            } else {
                numberOfOthers++;
            }
        }
        return numberOfNumbers > numberOfOthers;
    }
}
