import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) {
        //        String[] wordArray = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] wordArray = {"a", "b", "c"};
        List<String> wordList = Arrays.asList(wordArray);
        String beginWord = "a";
        String endWord = "c";
        List<List<String>> ret = new WordLadder2().findLadders(beginWord, endWord, wordList);
        for (int i = 0; i < ret.size(); i++) {
            List<String> l = ret.get(i);
            for (int j = 0; j < l.size(); j++) {
                System.out.print(l.get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        dict.add(beginWord);

        Map<String, List<String>> neighbors = new HashMap<>();

        Map<String, Integer> distance = new HashMap<>();
        distance.put(beginWord, 0);

        bfs(beginWord, endWord, dict, neighbors, distance);
        List<List<String>> ret = new ArrayList<>();
        dfs(beginWord, endWord, neighbors, distance, ret, new ArrayList<>());

        return ret;
    }

    public void bfs(String beginWord,
                    String endWord,
                    Set<String> dict,
                    Map<String, List<String>> neighbors,
                    Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            boolean foundEnd = false;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String w = queue.poll();
                int curDist = distance.get(w);

                List<String> neighbor = findNeighbors(w, dict);
                neighbors.put(w, neighbor);

                for (String s : neighbor) {
                    if (!distance.containsKey(s)) { // check if visited
                        distance.put(s, curDist + 1);
                        if (s.equals(endWord)) { // find endWord
                            foundEnd = true;
                        } else {
                            queue.offer(s);
                        }
                    }
                }
            }

            if (foundEnd) {
                break;
            }
        }
    }

    public List<String> findNeighbors(String word, Set<String> dict) {
        List<String> ret = new ArrayList<>();
        char[] cs = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char raw = cs[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == raw) {
                    continue;
                }
                cs[i] = c;
                String ns = new String(cs);
                if (dict.contains(ns)) {
                    ret.add(ns);
                }
            }
            cs[i] = raw;
        }

        return ret;
    }

    public void dfs(String beginWord,
                    String endWord,
                    Map<String, List<String>> neighbors,
                    Map<String, Integer> distance,
                    List<List<String>> ret,
                    List<String> solution) {
        solution.add(beginWord);
        if (beginWord.equals(endWord)) {
            ret.add(new ArrayList<>(solution));
        } else if (neighbors.get(beginWord) != null) {
            for (String neighbor : neighbors.get(beginWord)) {
                if (distance.get(neighbor) == distance.get(beginWord) + 1) {
                    dfs(neighbor, endWord, neighbors, distance, ret, solution);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}
