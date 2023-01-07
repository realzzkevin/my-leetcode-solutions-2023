public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int sum = 0;
        for(int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }

        if(sum >= 0) {
            int start = 0;
            int gasInTank = 0;
            for(int i = 0; i < diff.length; i++) {
                gasInTank += diff[i];
                if(gasInTank < 0) {
                    gasInTank = 0;
                    start = i+1;
                }
            }
            return start;
        }
        return -1;
    }
}
