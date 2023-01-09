class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        Map<String, Integer> seenMap = new HashMap<>();
        subsets.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++) {
            int n = subsets.size();
            for(int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(subsets.get(j));
                temp.add(nums[i]);
                String key = createKey(temp);
                if(!seenMap.containsKey(key)){
                    subsets.add(temp);
                    seenMap.put(key, 1);
                }
            }

        }
        return subsets;

    }

    public String createKey (List<Integer> list) {
        String s = "";
        for(Integer n : list){
            s += n;
        }
        return s;
    }
}