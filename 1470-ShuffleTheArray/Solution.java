class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] answer = new int[nums.length];
        int x = 0;
        int i = 0;
        while (i<nums.length) {
            answer[i++] = nums[x++];
            answer[i++] = nums[n++];
        }
        return answer;
    }
}