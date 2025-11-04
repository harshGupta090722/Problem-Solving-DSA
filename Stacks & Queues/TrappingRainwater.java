public class TrappingRainwater {
    public static int trap(int[] height) {
        int n = height.length;
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int trapped = 0;
        for (int i = 0; i < n; i++) {
            trapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return trapped;
    }

    public static void main(String args[]) {
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }
}