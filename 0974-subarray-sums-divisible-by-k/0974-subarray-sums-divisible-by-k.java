import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);   // remainder 0 occurs once

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            int remainder = sum % k;

            if (remainder < 0) {
                remainder += k;
            }

            count += map.getOrDefault(remainder, 0);

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}