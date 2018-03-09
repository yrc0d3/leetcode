public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 30;
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;
        while (top < bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][n - 1] == target) {
                return true;
            } else if (matrix[mid][n - 1] < target) {
                top = mid + 1;
            } else {
                bottom = mid;
            }
        }
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[top][mid] == target) {
                return true;
            } else if (matrix[top][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return matrix[top][left] == target;
    }
}
