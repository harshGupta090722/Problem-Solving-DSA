import java.util.*;

public class bit_Manipulation {

    public static void oddOrEven(int n) {
        if ((n & 1) == 1) {
            System.out.println("the number is odd");
        } else {
            System.out.println("the number is even");
        }
    }

    public static int getithBit(int n, int i) {
        int bitMask = 1 << i;
        return (n & bitMask) >> i;
    }

    public static int setithBit(int n, int i) {
        int bitMask = 1 << i;
        return (n | bitMask);
    }

    public static int clearithBit(int n, int i) {
        int bitMask = ~(1 << i);
        return (n & bitMask);
    }

    public static int updateithBit(int n, int i, int newBit) {
        if (newBit == 1) {
            return setithBit(n, i);
        } else {
            return clearithBit(n, i);
        }

        // learn another logic also later on
    }

    public static int clearIBits(int n, int i) {
        int bitMask = (~0) << i;// (~0)= -1 = 11111111
        return bitMask & n;
    }

    public static int clearRangeIBits(int n, int j, int i) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitmask = a | b;
        return n & bitmask;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        return count;
    }

    public static boolean powerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    public static int fastExponentiation(int a, int n) {

        int ans = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                ans = ans * a;
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static int fastModuloExponentiation(int X, int N, int M) {
        long ans = 1;
        long base = X % M;

        while (N > 0) {
            if ((N & 1) == 1)
                ans = (ans * base) % M;
            base = (ans * base) % M;
            N = N >> 1;
        }
        return (int) ans;
    }

    public static int countMinBitFlips(int start, int goal) {
        int count = 0;
        while (start > 0 || goal > 0) {
            if ((start & 1) != (goal & 1)) {
                count++;
            }
            start >>= 1;
            goal >>= 1;
        }
        return count;
    }

    public static List<List<Integer>> primeFactorization(int queries[]) {
        List<List<Integer>> result = new ArrayList<>();
        for (int num : queries) {
            int var = 2;
            List<Integer> factors = new ArrayList<>();
            while (num > 1) {
                if (num % var == 0) {
                    num = num / var;
                    factors.add(var);
                } else
                    var++;
            }
            result.add(factors);
        }
        return result;
    }


    public static void main(String args[]) {
        // System.out.println("Ans is "+( 9 & 4)); //AND operator
        // System.out.println("OR result is "+(9 | 4));//OR operator
        // System.out.println("XOR result is "+(9 ^ 4)); //XOR operator
        // System.out.println("NOT result is "+(~9));
        // oddOrEven(6);
        // getithBit(10, 3); //get the bit at ith index
        // setithBit(10, 2); //set the bit at ith index to 1
        // clearithBit(10,1);//set the bit at ith index to 0
        // System.out.println(updateithBit(10,2,1));// set the bit at ith index to 0
        // System.out.println(clearIBits(15, 2));
        // System.out.println(clearRangeIBits(10, 4, 2));
        // System.out.println(countSetBits(16));
        // System.out.println(fastExponentiation(5, 95));
        // System.out.println(countMinBitFlips(10, 7));
        // System.out.println(powerOfTwo(64));
        // System.out.println(fastModuloExponentiation(3, 1, 2));
        //int queries[] = { 2, 3, 4, 5, 6 };
        //System.out.println(primeFactorization(queries));
        
    }
}