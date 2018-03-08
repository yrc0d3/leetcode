public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("hello world"));
    }

    public int lengthOfLastWord(String s) {
        int tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail) == ' ') {
            tail--;
        }
        int len = 0;
        while (tail >= 0 && s.charAt(tail) != ' ') {
            len++;
            tail--;
        }
        return len;
    }
}
