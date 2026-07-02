class Solution {
    public int[] nextGreaterElements(int[] nums) {
       Stack<Integer> st = new Stack<>();
       int ans [] = new int[nums.length];
       int n= nums.length;

       for(int i = 2*n-1 ; i>=0 ; i--){
        while(!st.isEmpty() && nums[st.peek()] <= nums[i%n]){
            st.pop();
        }
        if(i<n){
            ans[i] = st.isEmpty() ? -1 : nums[st.peek()]; 
        }
        st.push(i%n);
       }
         return ans;

    }
  


}