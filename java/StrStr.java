public class StrStr {
    public static void main(String[] args) {
        System.out.print(new StrStr().strStr2("ababcabc", "abcabc"));
    }

    /*
    brute force
     */
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j;
                j = -1;
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    /*
    kmp
     */
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int[] next = getNextArr(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public int[] getNextArr(String s) {
        int n = s.length();
        int[] next = new int[n];
        next[0] = -1;
        int j = 0, k = -1;
        while (j < n - 1) {
            if (k == -1 || s.charAt(j) == s.charAt(k)) {
                j++;
                k++;
                if (s.charAt(j) != s.charAt(k)) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
