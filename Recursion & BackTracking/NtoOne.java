public class NtoOne {
    public static void printNToOne(int n) {
        if (n <1)
            return;
        
        System.out.println(n);
        printNToOne(n - 1);
    }

    public static void main(String args[]) {
        int n = 10;
        printNToOne(n);
    }
}