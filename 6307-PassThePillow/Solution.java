class Solution {
    public int passThePillow(int n, int time) {
        if(time < n - 1) {
            return time + 1;
        }
        int x = 2 * n - 2;
        int y = time % x;
        if( y >= n - 1) {
            return 2*n-y-1;
        } else {
            return y + 1;
        }
    }
}