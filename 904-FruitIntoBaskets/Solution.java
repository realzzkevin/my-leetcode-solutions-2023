class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length == 1){
            return 1;
        }
        int prev = 0;
        int curr = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < fruits.length; i++) {
            sum++;
            if(fruits[curr] != fruits[i]){
                if(fruits[prev] != fruits[i]){
                    sum = i - curr + 1;
                }
                prev = curr;
                curr = i;
            }
            max = Math.max(max, sum);
        }
        return max;

    }
}