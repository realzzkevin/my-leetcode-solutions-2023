class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            String temp = findPalidrome(s, i);
            ans = ans.length() > temp.length() ? ans : temp;
        }

        return ans;
    }

    public String findPalidrome(String s, int center) {
        int left = center;
        int right = center;

        while(left >= 0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        String str1 = s.substring(left+1, right);

        right = center + 1;
        if(right < s.length() && s.charAt(center) == s.charAt(right)) {
            left = center;
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                left--;
                right++;
            }
            String str2 = s.substring(left+1, right);
            return str1.length() > str2.length() ? str1 : str2;
        }

        return str1;


    }
}