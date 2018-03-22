import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle2 {
    public static void main(String[] args) {
        new PascalTriangle2().getRow(5).forEach(i -> System.out.print(i + ","));
    }

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>(), prev = new ArrayList<>(), tmp = null;
        prev.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(prev.get(j - 1) + prev.get(j));
            }
            list.add(1);
            tmp = prev;
            prev = list;
            list = tmp;
            list.clear();
        }
        list = prev;

        return list;
    }
}
