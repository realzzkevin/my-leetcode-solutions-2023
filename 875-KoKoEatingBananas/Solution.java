class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int n : piles) {
            right = Math.max(n, right);
        }
        while(left < right) {
            int mid = (left + right) / 2;
            int time = 0;
            for(int n : piles) {
                time += n / mid;
                if(n%mid > 0) {
                    time++;
                }
            }
            if(time <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}