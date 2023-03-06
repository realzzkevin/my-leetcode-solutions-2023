class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = 1;
        for(int num : arr){
            while(n != num){
                if(--k == 0 ){
                    return n;
                }
                n++;
            }
            n++;
        }
        return n-1+k;
    }
}