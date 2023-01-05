public class Solution {
    public int minDeletionSize(String[] strs) {
        int result = 0;
        int n = strs[0].length();
        for (int i = 0; i < n; i++) {
            char prev = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if(strs[j].charAt(i) < prev) {
                    result++;
                    break;
                } else {
                    prev = strs[j].charAt(i);
                }
            }
        }
        return result;
    }
}
