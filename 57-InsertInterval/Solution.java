class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length == 0) {
            int[][] arr = new int[1][1];
            arr[0] = newInterval;
            return arr;
        }

        List<int[]> intervalList = new ArrayList<>();
        //creat a temp interval to hold the result;
        int[] temp = new int[]{-1, -1};

        for( int i = 0; i < intervals.length; i++) {
            //find the first interval has it's ending bigger or equal to new interval start;
            if(intervals[i][1] >= newInterval[0]){
                //give the temp intverval values
                temp[0] = Math.min(newInterval[0], intervals[i][0]);
                temp[1] = newInterval[1];
                //try to find the intervals has its start smaller or equal to new interval ends.
                while(i < intervals.length && intervals[i][0] <= temp[1]){
                    temp[1] = Math.max(temp[1], intervals[i][1]);
                    i++;
                }
                // insert the temp interval
                intervalList.add(temp);
                // add in the remain intervals after temp;
                while(i < intervals.length) {
                    intervalList.add(intervals[i]);
                    i++;
                }
                break;

            }
            intervalList.add(intervals[i]);
        }
        //if temp interval still has it's defalult value, insert the new interval;
        if(temp[0] < 0) {
            intervalList.add(newInterval);
        }

        //return intervalList.toArray(new int[intervalList.size()][2]);
        int[][] results = new int[intervalList.size()][];
        for(int i = 0; i < results.length; i++) {
            results[i] = intervalList.get(i);
        }

        return results;
    }
}