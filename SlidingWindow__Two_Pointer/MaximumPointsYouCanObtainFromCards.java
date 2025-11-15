public class MaximumPointsYouCanObtainFromCards {

    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0, lsum = 0, rsum = 0, maxSum = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }

        int i = n - 1;
        while (k > 0) {
            sum = lsum + rsum;
            maxSum = Math.max(maxSum, sum);
            k--;
            lsum -= cardPoints[k];
            rsum += cardPoints[i];
            i--;
        }
        maxSum = Math.max(maxSum, lsum + rsum);
        return maxSum;
    }

    public static void main(String args[]) {
        int cardPoints[] = { 1, 2, 3, 4, 5, 6, 1 };
        System.out.println(maxScore(cardPoints, 3));
    }
}