public class atoi {
        public static int myAtoi(String s) {
            s = s.trim(); 
            if (s.length() == 0)
                return 0;

            long ans = 0;
            boolean positive = true;
            int startIdx = 0;

            if (s.charAt(0) == '-') {
                positive = false;
                startIdx++;
            } else if (s.charAt(0) == '+') {
                startIdx++;
            }

            for (int i = startIdx; i < s.length(); i++) {
                char ch = s.charAt(i);


                if (ch < '0' || ch > '9')
                    break;

                int digit = ch - '0';

                if (ans > (Integer.MAX_VALUE - digit) / 10) {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                ans = ans * 10 + digit;
            }

            if (!positive)
                ans = -ans;

            return (int) ans;
        }

    public static void main(String args[]) {
        String s = "+1";
        System.out.println(myAtoi(s));
    }
}