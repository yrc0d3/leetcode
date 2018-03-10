import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> ret = new Combinations().combine(4, 2);
        ret.forEach(list -> {
            list.forEach(num -> System.out.print(num + ","));
            System.out.println();
        });
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (n == 0 || k == 0) {
            return ret;
        }

        helper(n, k, 1, new ArrayList<>(), ret);
        return ret;
    }

    public void helper(int n, int k, int begin, ArrayList<Integer> list, List<List<Integer>> ret) {
        if (k == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i <= n; i++) {
            list.add(i);
            helper(n, k - 1, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }
}
