class Q1781 {
    public static int getMax(int freq[]) {
        int max = Integer.MIN_VALUE;
        for (int i : freq) {
            max = Math.max(i, max);
        }
        return max;
    }

    public static int getMin(int freq[]) {
        int min = Integer.MAX_VALUE;
        for (int i : freq) {
            if (i > 0)
                min = Math.min(i, min);
        }
        return min;
    }

    public static int beautySum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int freq[] = new int[26];
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                freq[ch - 'a']++;
                sum += getMax(freq) - getMin(freq);
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        String s = "aabcb";
        System.out.println(beautySum(s));
    }
}