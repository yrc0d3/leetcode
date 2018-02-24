import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> ret = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
        for (Integer i : ret) {
            System.out.println(i);
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < words.length * words[0].length()) {
            return ret;
        }

        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> map = new HashMap<>();

        int wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {
            int count = 0;
            map.clear();
            for (int validIndex = i, curIndex = i; curIndex + wordLen <= s.length(); curIndex += wordLen) {
                String curStr = s.substring(curIndex, curIndex + wordLen);
                if (countMap.containsKey(curStr)) {
                    map.put(curStr, map.getOrDefault(curStr, 0) + 1);
                    if (map.get(curStr) <= countMap.get(curStr)) {
                        count++;
                    } else {
                        while (map.get(curStr) > countMap.get(curStr)) {
                            String headStr = s.substring(validIndex, validIndex + wordLen);
                            map.put(headStr, map.get(headStr) - 1);
                            validIndex -= wordLen;
                            if (map.get(headStr) < countMap.get(headStr)) {
                                count--;
                            }
                        }
                    }
                    if (count == words.length) {
                        ret.add(validIndex);
                        String headStr = s.substring(validIndex, validIndex + wordLen);
                        map.put(headStr, map.get(headStr) - 1);
                        validIndex += wordLen;
                        count--;
                    }
                } else {
                    map.clear();
                    validIndex = curIndex + wordLen;
                    count = 0;
                }
            }
        }

        return ret;
    }
}
