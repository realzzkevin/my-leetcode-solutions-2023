class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long miniBustime = 0;
        int tripCount = 0;
        while(tripCount < totalTrips) {
            miniBustime ++;
            tripCount = 0;
            for(int i = 0; i < time.length; i++) {
                if(miniBustime / time[i] > 0) {
                    tripCount += miniBustime / time[i];
                } else {
                    break;
                }
            }
        }
        return miniBustime;
    }
}