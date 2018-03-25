public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "abA";
        System.out.println(new ValidPalindrome().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!isAlphanumeric(s.charAt(left))) {
                left++;
            } else if (!isAlphanumeric(s.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isAlphanumeric(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }
}
