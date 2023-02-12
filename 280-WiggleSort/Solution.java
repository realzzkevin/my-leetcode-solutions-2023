class Solution {
    //slow solution. need sort nums first;
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] returnVal = nums.clone();

        for(int i = 0, j = 0; i < nums.length && j < nums.length; j++ ){
            nums[i] = returnVal[j];
            i+=2;
            if(i >= nums.length){
                i = 1;
            }
        }
    }
}