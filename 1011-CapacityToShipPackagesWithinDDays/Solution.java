class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;

        for(int n : weights){
            sum += n;
            max = Math.max(max, n);
        }
        int l = max;
        int r = sum;

        while(l < r) {
            int mid = (r+l) / 2;
            if(shipmentTest(weights, days, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public boolean shipmentTest(int[] weights, int days, int capacity) {
        int currDays = 1;
        int dailyWeight = 0;

        for(int w : weights) {
            dailyWeight += w;
            if(dailyWeight > capacity){
                dailyWeight = w;
                currDays++;
            }
        }

        return currDays <= days;
    }
}