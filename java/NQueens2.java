public class NQueens2 {
    public static void main(String[] args) {
        System.out.println(new NQueens2().totalNQueens(5));
    }

    public int totalNQueens(int n) {
        boolean[] colFlags = new boolean[n];
        boolean[] d45Flags = new boolean[2 * n]; // linear equation: y = x + b
        boolean[] d135Flags = new boolean[2 * n]; // linear equation: y = -x + b
        return bfs(0, n, colFlags, d45Flags, d135Flags);
    }

    public int bfs(int row, int n, boolean[] colFlags, boolean[] d45Flags, boolean[] d135Flags) {
        if (row == n) {
            return 1;
        }
        
        int count = 0;
        for (int col = 0; col < n; col++) {
            int d45 = col - row + n;
            int d135 = col + row;
            if (colFlags[col] || d45Flags[d45] || d135Flags[d135]) {
                continue;
            }
            colFlags[col] = true;
            d45Flags[d45] = true;
            d135Flags[d135] = true;
            count += bfs(row + 1, n, colFlags, d45Flags, d135Flags);
            colFlags[col] = false;
            d45Flags[d45] = false;
            d135Flags[d135] = false;
        }

        return count;
    }
}
