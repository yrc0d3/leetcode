import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> ret = new PascalTriangle().generate(5);
        ret.forEach(list -> {
            list.forEach(i -> System.out.print(i + ","));
            System.out.println();
        });
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) {
            return ret;
        }
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        ret.add(row);
        for (int i = 1; i < numRows; i++) {
            row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
            }
            row.add(1);
            ret.add(row);
        }

        return ret;
    }
}
