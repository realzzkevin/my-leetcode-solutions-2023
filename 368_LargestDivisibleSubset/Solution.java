class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList();

        Integer[] dp = new Integer[n];
        Arrays.sort(nums);

        Integer maxSubsetSize = -1, maxSubsetIndex = -1;
        for (int i = 0; i < n; ++i) {
            Integer subsetSize = 0;
            for (int k = 0; k < i; ++k)
                if (nums[i] % nums[k] == 0 && subsetSize < dp[k])
                    subsetSize = dp[k];

            dp[i] = subsetSize + 1;

            if (maxSubsetSize < dp[i]) {
                maxSubsetSize = dp[i];
                maxSubsetIndex = i;
            }
        }

        LinkedList<Integer> subset = new LinkedList();
        Integer currSize = maxSubsetSize;
        Integer currTail = nums[maxSubsetIndex];
        for (int i = maxSubsetIndex; i >= 0; --i) {
            if (currSize == 0) break;

            if (currTail % nums[i] == 0 && currSize == dp[i]) {
                subset.addFirst(nums[i]);
                currTail = nums[i];
                currSize -= 1;
            }
        }

        return subset;
    }
}