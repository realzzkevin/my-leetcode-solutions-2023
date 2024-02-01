class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] results = new int[n];
        int hottest = 0;

        for (int curr = n-1; curr >= 0; curr--) {
            int currTemp = temperatures[curr];
            if (currTemp >= hottest) {
                hottest = currTemp;
                continue;
            }

            int days = 1;
            while (temperatures[curr + days] < currTemp) {
                days += results[curr + days];
            }

            results[curr] = days;
        }

        return results;

    }
}