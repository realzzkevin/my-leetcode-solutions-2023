class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while( l < r) {
            m = (r + l) / 2;
            m = m % 2 != 0 ? m-1 : m;
            if(nums[m + 1] == nums[m]){
                l = m + 2;
            } else {
                r = m;
            }
        }
        return nums[l];

    }
}