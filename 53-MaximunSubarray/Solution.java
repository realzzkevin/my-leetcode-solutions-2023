class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int localMax = 0;

        for(int i = 0; i < nums.length; i++) {
            localMax = Math.max(nums[i], nums[i]+ localMax);
            ans = Math.max(localMax, ans);
        }
        return ans;
    }
}