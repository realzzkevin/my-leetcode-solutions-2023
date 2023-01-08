class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 1){
            return 1;
        }
        Arrays.sort(points,(int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        int max = 2;
        for(int i = 0; i < points.length; i++ ){
            int temp = pointsInLine(points, i);
            max = Math.max(max, temp);
        }
        return max;

    }

    public int pointsInLine(int[][] p, int s) {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        Double delta;
        for(int i = s+1; i < p.length; i++) {
            int dx = p[i][0] - p[s][0];
            int dy = p[i][1] - p[s][1];
            if(dx == 0) {
                dy = Math.abs(dy);
            }
            delta = Math.atan2(dy, dx);
            map.put(delta, map.getOrDefault(delta, 1)+1);
        }
        int max = 2;
        for(int n : map.values()){
            max = Math.max(max, n);
        }
        return max;
    }
}