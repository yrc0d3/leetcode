public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(4));
    }

    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                count[i] += count[j - 1] * count[i - j];
            }
        }

        return count[n];
    }
}
