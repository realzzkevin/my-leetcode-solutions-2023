class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 1){
            return 1;
        }
        Arrays.sort(points,(int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        int max = 2;
        for(int i = 0; i < points.length; i++ ){
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            Double delta;
            for(int j = i+1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if(dx == 0) {
                    dy = Math.abs(dy);
                }
                delta = Math.atan2(dy, dx);
                map.put(delta, map.getOrDefault(delta, 1)+1);
            }
            for(int n : map.values()){
                max = Math.max(max, n);
            }
        }
        return max;
    }
}