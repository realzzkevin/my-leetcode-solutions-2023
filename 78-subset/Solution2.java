class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  answer = new ArrayList<>();
        int n = nums.length;
        for (int i = (int)Math.pow(2, n); i < Math.pow(2, n+1); i++){
            String mask = Integer.toBinaryString(i).substring(1);
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <  n; j++ ) {
                if(mask.charAt(j) == '1'){
                    list.add(nums[j]);
                }
            }
            answer.add(list);
        }
        return answer;
    }
}