public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        boolean extra = false;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0 && j >= 0) {
                sum = a.charAt(i--) - '0' + b.charAt(j--) - '0';
            } else if (i >= 0) {
                sum = a.charAt(i--) - '0';
            } else {
                sum = b.charAt(j--) - '0';
            }
            if (extra) {
                sum += 1;
                extra = false;
            }
            if (sum > 1) {
                extra = true;
                sum -= 2;
            }
            sb.append(sum);
        }
        if (extra) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
