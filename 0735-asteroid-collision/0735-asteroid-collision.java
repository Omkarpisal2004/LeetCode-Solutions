class Solution {
    public int[] asteroidCollision(int[] asteroids) {
      
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            boolean isAlive = true;

            while (!st.isEmpty()
                    && st.peek() > 0
                    && asteroids[i] < 0) {

                if (st.peek() < -asteroids[i]) {
                    st.pop();
                }
                else if (st.peek() == -asteroids[i]) {
                    st.pop();
                    isAlive = false;
                    break;
                }
                else {
                    isAlive = false;
                    break;
                }
            }

            if (isAlive) {
                st.push(asteroids[i]);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}