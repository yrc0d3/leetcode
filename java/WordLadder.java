import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(),
                visited = new HashSet<>(), wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 2;
        while (!beginSet.isEmpty()) {
            Set<String> nextLevelSet = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chs = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(i)) {
                            continue;
                        }
                        chs[i] = c;
                        String newWord = new String(chs);
                        if (endSet.contains(newWord)) {
                            return step;
                        }
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            nextLevelSet.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            beginSet = nextLevelSet;
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            step++;
        }

        return 0;
    }
}
