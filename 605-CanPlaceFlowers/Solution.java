class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int lengthOfZero = 0;

        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                if(i==0) {
                    lengthOfZero++;
                }
                if(i == flowerbed.length -1) {
                    lengthOfZero++;
                }
                lengthOfZero++;
                if(i == flowerbed.length - 1 && lengthOfZero >= 3) {
                    n -= (Math.ceil((double)lengthOfZero/2) - 1);
                }
            } else if(flowerbed[i] == 1){
                if(lengthOfZero >= 3) {
                    n -= (Math.ceil((double)lengthOfZero/2) - 1);
                }
                lengthOfZero = 0;
            }
        }
        return n <= 0;
    }
}