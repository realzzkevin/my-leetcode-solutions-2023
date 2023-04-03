class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for( int i = 0; i < spells.length; i ++) {
            long key =  (long)Math.ceil((1.0 * success) / spells[i]);

            if(potions[potions.length-1] < key) {
                result[i] = 0;
            } else {
                result[i] = binarySearch(potions, key);
            }
        }
        return result;
    }

    public int binarySearch(int [] potions, long key) {
        int left = 0;
        int right = potions.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if(potions[mid] >= key) {
                right = mid -1;
            } else {
                left = mid + 1;
            }

        }

        return potions.length - left;
    }
}