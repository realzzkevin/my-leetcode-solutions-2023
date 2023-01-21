class Solution {
    public int minFlipsMonoIncr(String s) {
        int leftFlips = 0;
        int rightFlips = 0;
        int minFlips = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                rightFlips++;
            }
        }

        minFlips = rightFlips;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                leftFlips++;
            } else if(s.charAt(i) =='0'){
                rightFlips--;
            }

            minFlips = Math.min(minFlips, leftFlips + rightFlips);
        }

        return minFlips;
    }
}