class Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        else if (strs.length == 1)
            return strs[0];

        StringBuffer common = new StringBuffer();
        int idx = 0;
        outer: for (int i = 1; i <= 200; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].length() > idx && strs[j + 1].length() > idx) {
                    
                    char ch1 = strs[j].charAt(idx);
                    char ch2 = strs[j + 1].charAt(idx);

                    if (ch1 != ch2)
                        return common.toString();

                    if (j == strs.length - 2)
                        common.append(ch1);
                } else
                    break outer;
            }
            idx++;
        }
        return common.toString();
    }

    public static void main(String args[]) {
        String strs[] = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}