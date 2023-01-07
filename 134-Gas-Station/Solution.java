public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int sum = 0;
        for(int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }

        if(sum >= 0) {
            for(int i = 0; i < diff.length; i++) {
                int next = 0;
                for(int r = i; r < diff.length; r++) {
                    next += diff[r];
                    if(next < 0) {
                        break;
                    }
                }
                if(next >= 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
