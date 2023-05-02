class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int n : salary) {
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        sum -= min;
        sum -= max;
        return (double)sum/(salary.length-2);
    }
}