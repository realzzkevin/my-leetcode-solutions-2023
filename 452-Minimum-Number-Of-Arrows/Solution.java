public class Solution {
    public int findMinArrowShots(int[][] points) {
        //sort array points by Xstart
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int[] temp = null;
        int sum = 1;
        for(int i = 1; i < points.length; i++) {
            if(temp == null) {
                temp = findOverlap(points[i-1], points[i]);
            } else {
                temp = findOverlap(temp, points[i]);
            }
            if(temp == null) {
                sum++;
            }
        }
        return sum;
    }

    public int[] findOverlap(int[] arr1, int[] arr2) {
        int[] result = new int[2];
        if(arr2[0] <= arr1[1]){
            result[0] = Math.max(arr1[0], arr2[0]);
            result[1] = Math.min(arr1[1], arr2[1]);
        } else {
            result = null;
        }
        return result;
    }
}
