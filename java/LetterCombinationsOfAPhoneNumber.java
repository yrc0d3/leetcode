import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        List<String> ret = new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
        for (String s : ret) {
            System.out.println(s);
        }
    }

    static String[][] map = {
            {""},
            {""},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
    };

    // recursive method
    // another iterative method is to use a LinkedList as a FIFO queue
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        if (digits.length() == 1) {
            return Arrays.asList(map[digits.charAt(0) - '0']);
        }

        List<String> ret = new ArrayList<>();
        List<String> recursive = letterCombinations(digits.substring(1));
        String[] letters = map[digits.charAt(0) - '0'];
        for (String letter : letters) {
            for (String s : recursive) {
                ret.add(letter + s);
            }
        }
        return ret;
    }
}
