class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, nums.length);
        return nums;

    }

    private void sort(int[] nums, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int [] l = new int[mid];
        int [] r = new int[n - mid];

        for (int i = 0; i < mid; i++){
            l[i] = nums[i];
        }

        for(int i = mid; i < n; i++){
            r[i-mid] = nums[i];
        }

        sort(l, mid);
        sort(r, n - mid);
        merge(nums, l, r, mid, n - mid);

    }

    private void merge(int[] nums, int[] l, int[] r, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left && j < right) {
            if(l[i] <= r[j]){
                nums[k++] = l[i++];
            } else {
                nums[k++] = r[j++];
            }
        }

        while( i < left) {
            nums[k++] = l[i++];
        }
        while (j < right) {
            nums[k++] = r[j++];
        }

    }
}