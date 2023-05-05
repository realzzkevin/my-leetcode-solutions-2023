class Solution {
    public int maxVowels(String s, int k) {
        int[] alphabet = new int[26];
        for (int i = 0; i < k; i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        int maxVowels = alphabet[0] + alphabet[4] +alphabet[8] +alphabet[14] + alphabet[20];

        for (int i = 0; i < s.length() - k; i++) {
            alphabet[s.charAt(i) - 'a']--;
            alphabet[s.charAt(i+k) -'a']++;
            int temp = alphabet[0] + alphabet[4] +alphabet[8] +alphabet[14] + alphabet[20];
            maxVowels = Math.max(maxVowels, temp);
        }
        return maxVowels;
    }
}