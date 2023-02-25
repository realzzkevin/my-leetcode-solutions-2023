class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int p : prices) {
            if(buyPrice > p) {
                buyPrice = p;
            } else if(p - buyPrice > maxProfit){
                maxProfit = p - buyPrice;
            }
        }
        return maxProfit;
    }
}