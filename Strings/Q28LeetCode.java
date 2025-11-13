class Q28LeetCode {

    public static int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0, ans = i;
                while (j < needle.length() && i < haystack.length() && haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                }
                if (j == needle.length())
                    return ans;

                i = ans;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        System.out.println(strStr("aaa", "aaaa"));
    }
}