class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  answer = new ArrayList<>();
        answer.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++) {
            int n = answer.size();
            for(int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(answer.get(j));
                temp.add(nums[i]);
                answer.add(temp);
            }
        }
        return answer;
    }
}