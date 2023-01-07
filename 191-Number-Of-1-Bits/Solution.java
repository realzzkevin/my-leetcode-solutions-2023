public class Solution {
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1'){
                sum++;
            }
        }
        return sum;
    }
}
