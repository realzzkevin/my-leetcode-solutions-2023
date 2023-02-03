class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        // run binary search first to determen if target exits.
        int mid = binarySearch(nums, target, 0, nums.length - 1);
        // find left end;
        int temp = mid;
        while(temp != -1) {
            result[0] = temp;
            temp = binarySearch(nums, target, 0, result[0]-1);
        }
        //find right end;
        temp = mid;
        while(temp != -1) {
            result[1] = temp;
            temp = binarySearch(nums, target, result[1]+1, nums.length - 1);
        }
        return result;
    }
    //stander binary search methods.
    public int binarySearch(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}