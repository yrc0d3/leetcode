public class Sqrt {
    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt2(9));
    }

    public int mySqrt(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    // Newton
    public int mySqrt2(int x) {
        long ret = x;
        while (ret * ret > x) {
            ret = (ret + x / ret) / 2;
        }
        return (int) ret;
    }
}
