import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        triangle.add(row1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(2);
        row2.add(3);
        triangle.add(row2);
        System.out.println(new Triangle().minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }

        int[] sum = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    sum[j] = triangle.get(i).get(j) + sum[j];
                } else if (j == i) {
                    sum[j] = triangle.get(i).get(j) + sum[j - 1];
                } else {
                    sum[j] = triangle.get(i).get(j) + Math.min(sum[j - 1], sum[j]);
                }
            }
        }

        int ret = sum[0];
        for (int i = 1; i < sum.length; i++) {
            ret = Math.min(ret, sum[i]);
        }

        return ret;
    }
}
