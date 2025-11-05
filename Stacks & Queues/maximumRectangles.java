import java.util.Stack;

public class maximumRectangles {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int row = matrix.length;
        int col = matrix[0].length;
        int heights[][] = new int[row][col];

        for (int j = 0; j < col; j++) {
            heights[0][j]=matrix[0][j]-'0';
            for (int i = 1; i < row; i++) {
                if(matrix[i][j]=='1'){
                    heights[i][j]=heights[i-1][j]+1;
                }else{
                   heights[i][j]=0;
                }
            }
        }
         int maxArea = 0;
        for (int i = 0; i < row; i++) {
            int area = largestRectangleArea(heights[i]);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        //nse
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nse[i] = n;
            else
                nse[i] = st.peek();

            st.push(i);
        }
        st.clear();

        //pse
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                pse[i] = -1;
            else
                pse[i] = st.peek();

            st.push(i);

        }
        
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nse[i] - pse[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }

    public static void main(String args[]) {
        char matrix[][] = { { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalRectangle(matrix));
    }
}