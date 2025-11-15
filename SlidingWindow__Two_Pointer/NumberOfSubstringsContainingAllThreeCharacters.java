public class NumberOfSubstringsContainingAllThreeCharacters {

    public static int numberOfSubstrings(String s) {
        int left=0,count = 0,n=s.length();
        int freq[]=new int[3];

        for (int right = 0; right <n; right++) {
        char ch=s.charAt(right);
        freq[ch-'a']++;

        while((freq[0]>0 && freq[1]>0 && freq[2]>0)){
        count+=(n-right);
        freq[s.charAt(left)-'a']--;
        left++;
         }
        }
        return count;
    }

    public static void main(String args[]) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}