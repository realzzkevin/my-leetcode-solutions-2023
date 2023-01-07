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

    //bitwise solution 1
    // int count = 0;
    // int mask = 1;
    // for (int i = 0; i < 32; i++) {
    //     if((n & mask) != 0) {
    //         count++;
    //     }
    //     mask <<= 1;
    // }
    // return count;

    //bitwise solutuion 2
    // int count = 0;
    // while (n != 0) {
    //     count++;
    //     n &= (n-1);
    // }
    // return count;
}
