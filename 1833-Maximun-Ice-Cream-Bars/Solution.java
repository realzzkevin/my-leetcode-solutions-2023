public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int total = 0;
        int i = 0;

        while (coins > 0 && i < costs.length){
            if(coins >= costs[i]){
                coins -= costs[i];
                total++;
            }
            i++;
        }

        return total;
    }
}
