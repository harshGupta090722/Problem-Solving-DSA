import java.util.*;
public class MaximumSquareAreaByRemovingFencesFromAField {

    public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        ArrayList<Integer> hfences = new ArrayList<>();
        hfences.add(1);
        for (int i : hFences) {
            hfences.add(i);
        }
        hfences.add(m);
        Collections.sort(hfences);

        ArrayList<Integer> vfences = new ArrayList<>();
        vfences.add(1);
        for (int i : vFences) {
            vfences.add(i);
        }
        vfences.add(n);
        Collections.sort(vfences);

        HashSet<Integer> hset = new HashSet<>();

        for (int i = 0; i < hfences.size(); i++) {
            for (int j = i + 1; j < hfences.size(); j++) {
                hset.add(hfences.get(j) - hfences.get(i));
            }
        }

        HashSet<Integer> vset = new HashSet<>();

        for (int i = 0; i < vfences.size(); i++) {
            for (int j = i + 1; j < vfences.size(); j++) {
                vset.add(vfences.get(j) - vfences.get(i));
            }
        }

        int maxSquareSide = 0;

        for (int len : hset) {
            if (vset.contains(len)) {
                maxSquareSide = Math.max(len, maxSquareSide);
            }
        }

        if (maxSquareSide == 0)
            return -1;

        long maxArea = (long) maxSquareSide * maxSquareSide;

        return (int)(maxArea % 1_000_000_007);
    }
    public static void main(String args[]){
        int m=4;
        int n=3;

        int hFences[]={2,3};
        int vFences[]={2};

        System.out.println(maximizeSquareArea(m, n, hFences, vFences));
    }
}