class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int l = 0;
        for(int r = 0; r < s.length; r++) {
            if(s[r] == ' '){
                if(r > 0) {
                    reverse(s, l, r - 1);
                    l = r + 1;
                }
            } else if(r == s.length -1){
                reverse(s, l, r);
            }
        }
    }

    public void reverse(char[] s, int left, int right) {
        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right--;
        }
    }
}