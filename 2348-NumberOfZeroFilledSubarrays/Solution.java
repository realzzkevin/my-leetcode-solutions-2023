class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long ans = 0;
        for(int n : nums) {
            if(n == 0){
                count++;
                ans += count;
            } else {
                count = 0;
            }
        }
        return ans;
    }
}