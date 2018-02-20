public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("2147483648"));
        System.out.println(new StringToInteger().myAtoi("-2147483648"));
    }

    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int sign = 1, index = 0, base = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) {
            return 0;
        }

        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            int n = str.charAt(index) - '0';
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && n > Integer.MAX_VALUE % 10)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = base * 10 + n;
            index++;
        }

        return base * sign;
    }
}
