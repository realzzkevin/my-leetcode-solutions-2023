class Solution {
    public int jump(int[] nums) {
         if(nums.length == 0 || nums.length == 1) {
             return 0;
         }
        int n = nums.length;
        int minStep = 0;
        int curr = 0;

        while (curr <= n-1) {
            if(curr + nums[curr] >= n-1) {
                return ++minStep;
            }
            int nextIndex = curr + 1;
            for(int i = curr+1; i < n && i <= curr + nums[curr]; i++ ){
                if(nextIndex+nums[nextIndex] < i + nums[i]){
                    nextIndex = i;
                }
            }
            curr = nextIndex;
            minStep++;
        }
        return minStep;
    }
}