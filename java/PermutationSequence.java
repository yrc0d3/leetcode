public class PermutationSequence {
    public static void main(String[] args) {
        int n = 3;
        int k = 6;
        System.out.println(new PermutationSequence().getPermutation(n, k));
    }

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (k >= factorial[n - i]) {
                int nth = (k - 1) / factorial[n - i] + 1;
                sb.append(getNthUnused(used, nth));
                k = (k - 1) % factorial[n - i] + 1;
            } else {
                sb.append(getNthUnused(used, 1));
            }
        }

        return sb.toString();
    }

    public int getNthUnused(boolean[] used, int n) {
        int i = 0;
        while (n > 0) {
            if (!used[i]) {
                n--;
            }
            i++;
        }
        used[i - 1] = true;
        return i;
    }
}
