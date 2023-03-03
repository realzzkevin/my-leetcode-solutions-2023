class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) {
            return 1;
        }
        int compressIndex = 1;
        char currChar = chars[0];
        int charCount = 1;

        for(int i = 1; i < chars.length; i++) {
            if(chars[i] != currChar) {
                compressIndex = storeNumber(chars, compressIndex, charCount);
                currChar = chars[i];
                chars[compressIndex] = chars[i];
                compressIndex++;
                charCount  = 1;
            } else {
                charCount++;
                if(i == chars.length - 1) {
                    compressIndex = storeNumber(chars, compressIndex, charCount);
                }
            }
        }

        return compressIndex;

    }

    public int storeNumber(char[] chars, int start, int charCount) {
        if(charCount == 1) {
            return start;
        }
        String s = Integer.toString(charCount);
        int i;
        for( i = 0 ; i < s.length(); i++) {
            chars[start + i] = s.charAt(i);
        }
        return start+i;
    }
}