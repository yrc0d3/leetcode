public class Pow {
    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2.0, 10));
    }

    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return myPow(x * x, n / 2);
        }
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, n / 2);
        }
    }
}
