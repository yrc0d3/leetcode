public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }

    public String countAndSay(int n) {
        String ret = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char c = ret.charAt(0);
            for (int j = 1; j < ret.length(); j++) {
                if (ret.charAt(j) == ret.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    c = ret.charAt(j);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(c);
            ret = sb.toString();
        }

        return ret;
    }
}
