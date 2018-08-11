import java.util.*;

public class WordBreak2 {
    private int minLen = Integer.MAX_VALUE;
    private int maxLen = 0;

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        String s = "pineapplepenapple";
        List<String> ret = new WordBreak2().wordBreak(s, wordDict);
        for (String r : ret) {
            System.out.println("\"" + r + "\"");
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
            set.add(word);
        }

        return helper(s, set, new HashMap<>());
    }

    public List<String> helper(String s, Set<String> set, HashMap<String, List<String>> cache) {
        List<String> ret = new ArrayList<>();
        if (s.length() == 0) {
            ret.add("");
            return ret;
        }

        for (int i = minLen; i <= s.length() && i <= maxLen; i++) {
            String w = s.substring(0, i);
            if (set.contains(w)) {
                List<String> tmp;
                String rest = s.substring(i);
                if (cache.containsKey(rest)) {
                    tmp = cache.get(rest);
                } else {
                    tmp = helper(rest, set, cache);
                }
                for (String ss : tmp) {
                    ret.add(w + (ss.equals("") ? "" : " ") + ss);
                }
            }
        }

        cache.put(s, ret);

        return ret;
    }
}
