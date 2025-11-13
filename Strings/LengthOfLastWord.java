public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return s.length() - 1 - i;
    }

    public static void main(String args[]) {
        System.out.println(lengthOfLastWord("fly me to the moon       "));
    }
}