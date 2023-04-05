class Solution {
    public int partitionString(String s) {
        int[] alphabet = new int[26];
        int answer = 1;
        for(int i = 0; i < s.length(); i++) {
            if(alphabet[s.charAt(i) - 'a'] > 0 ) {
                answer++;
                Arrays.fill(alphabet, 0);
            }
            alphabet[s.charAt(i) - 'a'] = 1;
        }

        return answer;
    }
}