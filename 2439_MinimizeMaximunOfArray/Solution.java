class Solution {
    public int minimizerArrayValue(int[] nums) {
        long prefixSum = nums[0];
        long answer = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSum += nums[i];
            answer = Math.max(answer, (prefixSum + i)/(i+1));
        }

        return (int) answer;
    }
}