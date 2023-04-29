class Solution {
    public int addDigits(int num) {
        while (num >= 10 ) {
            int carry = 0;
            while (num > 0) {
                carry += num %10;
                num /= 10;
            }
            num = carry;
        }
        return num;
    }
}