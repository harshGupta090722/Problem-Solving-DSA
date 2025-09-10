package Binary_Search;

public class Nthsq_root {
    public static int NthRoot(int N, int M) {
        int l=1,r=M,sqrt=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            System.out.println(mid);
            if(mid==M/mid){
            N--;
            sqrt=mid;
            l=1;
            r=mid;
            if(N==0) break;
            }else if(mid>M/mid)
                r=mid-1;
            else
                l=mid+1;
        }

        int product=1;
        while(N-->0){
        product=product*sqrt;
        }
        if(product==M)
            return sqrt;

        return -1;
    }

    public static void main(String args[]){
        System.out.println(NthRoot(3,27));
    }
}