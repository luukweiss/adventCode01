import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("D:\\2. Documenten\\Programming projects\\day2input.txt"));
        ArrayList<String> boxIDs = new ArrayList<>();

        String line = br.readLine();

        // for all the lines
        while(line != null) {
            boxIDs.add(line);
            line = br.readLine();
        }

        String answer = "";
        for(int i = 1; i < boxIDs.size(); i++) {
            String word1 = boxIDs.get(i - 1);
            String word2 = boxIDs.get(i);

            answer = check(word1, word2);
        }
        System.out.println("The answer is: " + answer);

//        int countTwos = 0;
//        int countThrees = 0;

//        for(String boxID: boxIDs) {
//
//            boolean twos = false;
//            boolean threes = false;
//
//            for(int i = 0; i < boxID.length(); i++) {
//                char current = boxID.charAt(i);
//
//                // check this character in the boxID string
//                int amountOfThisCharInString = amountOfOcurrenceOfChar(boxID, current);
//
//                // if there are exactly 2 or three of the same character in this word, set the two or three flag on
//                if(amountOfThisCharInString == 2) {
//                    twos = true;
//                }
//                else if (amountOfThisCharInString == 3) {
//                    threes = true;
//                }
//            }
//
//            // count the amount of times the two and three flags are being set
//            if(twos) {
//                countTwos++;
//            }
//            if (threes) {
//                countThrees++;
//            }
//        }

//        System.out.println("Amount of two: " + countTwos + " \nAmount of three: " + countThrees);
//        int multiply = countTwos * countThrees;
//       System.out.println(multiply);
    }

    /**
     *
     * @param c character to check.
     * @return the amount that character is present in the list
     */
    private static int amountOfOcurrenceOfChar(String boxID, char c) {
        int count = 0;
        for(int i = 0; i < boxID.length(); i++) {
            char current = boxID.charAt(i);
            if(current == c) {
                count++;
            }
        }
        return count;
    }

    // Checks if two words differ by just one char. If they do, remove that char from the string.
    private static String check(String word1, String word2) {

        String answerString = "";

        boolean failSafe = true;
        boolean isValid = true;

        if(word1.length() == word2.length()) {
            int posCharDiffer = 0;
            // for every character in a string
            for(int i = 0; i < word1.length(); i++) {
                char word1Char = word1.charAt(i);
                char word2Char = word2.charAt(i);

                if(word1Char != word2Char) {
                    // oh no, these differ! No worries if you have a failSafe!
                    if(!failSafe) {
                        isValid = false;
                        break;
                    }
                    failSafe = false;
                    // because if you have just one, save the position
                    posCharDiffer = i;
                }
            }
            if(isValid && !failSafe) {
                // these words have one small character change!
                answerString = removeCharAt(word1, posCharDiffer);
            }
        }
        return answerString;
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}
