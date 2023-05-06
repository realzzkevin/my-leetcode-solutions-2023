class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod = 1000000007;
        Arrays.sort(nums);

        int[] power = new int[n];
        power[0] = 1;
        for(int i = 1; i < n; ++i){
            power[i] = (power[i -1] * 2) % mod;
        }

        int answer = 0;
        for(int left = 0; left < n; left++){
            int right = biSearch(nums, target - nums[left]) -1;
            if(right >= left) {
                answer += power[right - left];
                answer %= mod;
            }
        }

        return answer;
    }

    public int biSearch(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}