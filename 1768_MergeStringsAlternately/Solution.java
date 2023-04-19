class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length() > word2.length() ? word1.length() : word2.length();
        int i = 0;
        StringBuilder str = new StringBuilder();
        while(i < n) {
            if(i < word1.length()) {
                str.append(word1.charAt(i));
            }

            if(i < word2.length()) {
                str.append(word2.charAt(i));
            }
            i++;
        }
        return str.toString();
    }
}