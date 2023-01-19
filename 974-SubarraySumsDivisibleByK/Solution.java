class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int sum = 0;
        int[] subsums = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i > 0) {
                subsums[i] = nums[i] + subsums[i-1];
            } else {
                subsums[i] = nums[i];
            }
            if(subsums[i] % k == 0) {
                sum++;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                subsums[j] = subsums[j] - subsums[i];
                if(subsums[j] % k == 0) {
                    sum++;
                }
            }
        }

        return sum;
    }
}