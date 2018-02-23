public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(1, 1));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        int ret = 0;
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        while (longDividend >= longDivisor) {
            long tmpDivisor = longDivisor, base = 1;
            while (longDividend >= (tmpDivisor << 1)) {
                tmpDivisor <<= 1;
                base <<= 1;
            }
            longDividend -= tmpDivisor;
            ret += base;
        }

        return sign > 0 ? ret : -ret;
    }
}
