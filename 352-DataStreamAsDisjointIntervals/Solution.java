class SummaryRanges {

    private Set<Integer> values;

    public SummaryRanges() {
        values = new TreeSet<>();
    }
    
    public void addNum(int value) {
        values.add(value);
    }
    
    public int[][] getIntervals() {
        if(values.isEmpty()) {
            return new int[0][0];
        }

        List<int[]> intervals = new ArrayList<>();
        int left = -1;
        int right = -1;
        for(Integer n : values) {
            if(left < 0) {
                left = n;
                right = n;
            } else if(n == right + 1){
                right = n;
            } else {
                intervals.add(new int[]{left, right});
                left = n;
                right = n;
            }
        }

        intervals.add(new int[]{left, right});
        return intervals.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
