class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        int max = 0;
        for(int num : candies) {
            max = num > max ? num : max;
        }
        List<Boolean> list = new ArrayList<>();
        for(int num : candies) {
            list.add((num + extraCandies) >= max);
        }
        return list;
    }
}