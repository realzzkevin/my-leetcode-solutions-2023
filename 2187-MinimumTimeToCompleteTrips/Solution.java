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

//Binary search solution
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long right = (long)time[time.length-1] * totalTrips;
        System.out.println(right);
        long left = 1;

        while (left < right) {
            long mid = (left + right) / 2;
            if(enoughTime(time, mid, totalTrips)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean enoughTime(int[] time, long setTime, int totalTrips) {
        long tripCount = 0;
        for(int i = 0; i < time.length; i++) {
            if(setTime / time[i] >0){
                tripCount += setTime / time[i];
            } else {
                break;
            }
        }
        return tripCount >= totalTrips;
    }
}