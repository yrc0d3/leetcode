import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = 0;
        int begin = 0, end = 0, head = 0, len = Integer.MAX_VALUE;
        while (end < s.length()) {
            char cur = s.charAt(end);
            end++;
            if (!map.containsKey(cur)) {
                continue;
            }

            if (map.get(cur) > 0) {
                count++;
            }
            map.put(cur, map.get(cur) - 1);
            while (count == t.length()) {
                char charAtBegin = s.charAt(begin);
                if (end - begin < len) {
                    head = begin;
                    len = end - begin;
                }
                if (map.containsKey(charAtBegin)) {
                    if (map.get(charAtBegin) == 0) {
                        count--;
                    }
                    map.put(charAtBegin, map.get(charAtBegin) + 1);
                }
                begin++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    }

    // using int array as map, make it faster
    public String minWindow1(String s, String t) {
        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[256];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int count = t.length(), begin = 0, end = 0, len = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            if (map[s.charAt(end)] > 0) {
                count--;
            }
            map[s.charAt(end)]--;
            end++;
            while (count == 0) {
                if (end - begin < len) {
                    head = begin;
                    len = end - begin;
                }
                if (map[s.charAt(begin)] == 0) {
                    count++;
                }
                map[s.charAt(begin)]++;
                begin++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    }
}
