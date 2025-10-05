//No. of ways to tile “2*n” board using  tiles of size“2*1”.You can place tiles horizontally and vertically.  
public class tilingProblem {

    public static int tileWays(int n) {
        if (n == 0 || n == 1)
            return 1;
        return tileWays(n - 1) + tileWays(n - 2);
    }

    public static void main(String argsp[]) {
        System.out.println(tileWays(4));
    }
}