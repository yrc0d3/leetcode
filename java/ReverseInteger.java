public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(123));
    }

    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int tmp = ret * 10 + x % 10;
            if (tmp / 10 != ret) {
                // overflow
                return 0;
            }
            ret = tmp;
            x /= 10;
        }

        return ret;
    }
}
