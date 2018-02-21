import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("[]"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
