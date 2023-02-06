class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        if(nums[right] < nums[left]){
            int pivot = -1;
            while(left <= right) {
                pivot = left + (right - left) /2;
                if(nums[pivot] > nums[pivot+1] ){
                    pivot++;
                    break;
                } else {
                    if(nums[pivot] < nums[left]){
                        right = pivot - 1;
                    } else {
                        left = pivot + 1;
                    }
                }

            }
            left = 0;
            right = nums.length - 1;

            if(target <= nums[right]){
                left = pivot;
            } else {
                right = pivot - 1;
            }
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(target > nums[mid]){
                left = mid + 1;
            } else if(target < nums[mid]){
                right = mid -1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}