import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ret = new GroupAnagrams().groupAnagrams(strs);
        ret.forEach((list) -> {
            list.forEach((str) -> System.out.print(str + ","));
            System.out.println();
        });
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedStrToListMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (!sortedStrToListMap.containsKey(sortedStr)) {
                sortedStrToListMap.put(sortedStr, new ArrayList<>());
            }
            sortedStrToListMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(sortedStrToListMap.values());
    }
}
