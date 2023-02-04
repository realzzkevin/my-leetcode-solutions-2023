class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if(isEqual(arr1, arr2)){
            return true;
        }

        int left = 0;
        int right = s1.length() -1;
        while (right < s2.length()-1){
            arr2[s2.charAt(left) - 'a']--;
            left++;
            right++;
            arr2[s2.charAt(right) -'a']++;
            if(isEqual(arr1, arr2)){
                return true;
            }
        }

        return false;

    }

    public boolean isEqual(int[] a1, int[] a2) {
        for(int i = 0; i < a1.length; i++) {
            if(a1[i] != a2[i]){
                return false;
            }
        }
        return true;
    }
}