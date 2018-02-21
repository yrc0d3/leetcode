import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> ret = new GenerateParentheses().generateParenthesis(3);
        for (String s : ret) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        helper(ret, "", n, n);
        return ret;
    }

    public void helper(List<String> ret, String cur, int left, int right) {
        if (left == 0 && right == 0) {
            ret.add(cur);
            return;
        }
        if (left > 0) {
            helper(ret, cur + "(", left - 1, right);
        }
        if (right > left) {
            helper(ret, cur + ")", left, right - 1);
        }
    }
}
