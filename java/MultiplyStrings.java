public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("101", "100"));
    }

    // num1[i] * num2[j] will be placed at indices[i + j, i + j + 1]
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                multiply += pos[i + j + 1];
                pos[i + j + 1] = multiply % 10;
                pos[i + j] += multiply / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos.length; i++) {
            if (sb.length() == 0 && pos[i] == 0) {
                continue;
            }
            sb.append(pos[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
