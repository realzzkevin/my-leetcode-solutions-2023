class Solution {
    public String minWindow(String s, String t) {
        int[] targetFreq = new int[58];
        int[] sFreq = new int[58];
        String ans = "";

        for (int i = 0; i < t.length(); i++) {
            targetFreq[t.charAt(i) - 'A']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // advance right until hit all charCount;
            int rightIndex = s.charAt(right) - 'A';
            sFreq[rightIndex]++;
            if (isCoveredAll(sFreq, targetFreq)) {
                String temp = s.substring(left, right + 1);
                ans = temp.length() < ans.length() || ans == "" ? temp : ans;
                // advance left while the string still cover all letters;
                while (isCoveredAll(sFreq, targetFreq) && left < right) {
                    int leftIndex = s.charAt(left) - 'A';
                    sFreq[leftIndex]--;
                    left++;
                    if (!isCoveredAll(sFreq, targetFreq)) {
                        break;
                    } else {
                        String temp2 = s.substring(left, right + 1);
                        ans = temp2.length() < ans.length() || ans == "" ? temp2 : ans;
                    }
                }
            }

        }

        return ans;
    }

    public boolean isCoveredAll(int[] s, int[] t) {
        for (int i = 0; i < s.length; i++) {
            if (t[i] != 0 && s[i] < t[i]) {
                return false;
            }
        }

        return true;
    }
}