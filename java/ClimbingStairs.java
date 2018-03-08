public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(2));
    }

    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (--n > 0) {
            a = (b += a) - a;
        }
        return b;
    }
}
