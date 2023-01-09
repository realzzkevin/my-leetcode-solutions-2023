class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }
        int[] indexs = new int[2];
        for(int i = 0; i < s.length(); i++) {
            int[] temp = findPalidrome(s, i);
            if((temp[1] - temp[0]) > (indexs[1] - indexs[0])){
                indexs[0] = temp[0];
                indexs[1] = temp[1];
            }
        }
        return s.substring(indexs[0], indexs[1]);
    }

    public int[] findPalidrome(String s, int center) {
        int left = center;
        int right = center;
        int[] returnval = new int[2];

        while(left >= 0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        returnval[0] = left+1;
        returnval[1] = right;

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

            if((right - (left + 1)) > (returnval[1] - returnval[0])){
                returnval[0] = left + 1;
                returnval[1] = right;

            }
        }
        return returnval;
    }
}