class Solution {
    public boolean canJump(int[] nums) {
        int nextStop = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i+nums[i] > nextStop){
                nextStop = i+nums[i];
            }
        }
        return true;
    }
}