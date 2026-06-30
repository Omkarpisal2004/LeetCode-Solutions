class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;

        int row = matrix.length;
        int col = matrix[0].length;

        int maxArea = 0;
        int[] height = new int[col];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, histogram(height));
        }

        return maxArea;
    }

    private int histogram(int[] height) {

        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller (Left)
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() &&
                   height[st.peek()] >= height[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Next Smaller (Right)
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() &&
                   height[st.peek()] >= height[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = st.peek();
            }

            st.push(i);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = width * height[i];

            max = Math.max(max, area);
        }

        return max;
    }
}