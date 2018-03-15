import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
//        String s = "25525511135";
        String s = "010010";
        new RestoreIPAddresses().restoreIpAddresses(s).forEach(System.out::println);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        helper(s, 0, 0, new StringBuilder(), ret);
        return ret;
    }

    public void helper(String s, int index, int count, StringBuilder sb, List<String> ret) {
        if (index > s.length() || count > 4 || (index == s.length() && count != 4)) {
            return;
        }
        if (count == 4 && index == s.length()) {
            ret.add(sb.toString());
            return;
        }

        for (int len = 1; len <= (s.charAt(index) == '0' ? 1 : 3) && (index + len) <= s.length(); len++) {
            String ns = s.substring(index, index + len);
            int ni = Integer.valueOf(ns);
            if (0 <= ni && ni <= 255) {
                sb.append(ns);
                if (count < 3) {
                    sb.append('.');
                }
                helper(s, index + len, count + 1, sb, ret);
                if (count < 3) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.delete(sb.length() - len, sb.length());
            }
        }
    }
}
