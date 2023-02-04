
// use Less space but slower. Why???
class Solution2 {
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
        int hit = 0;
        for(int i =0; i < 26; i++){
            if(arr1[i] == arr2[i]){
                hit++;
            }
        }
        for(int i = s1.length(); i < s2.length(); i++){
            if(hit==26) {
                return true;
            }
            int prev = s2.charAt(i-s1.length()) -'a';
            int next = s2.charAt(i)-'a';
            arr2[next]++;
            if(arr2[next] == arr1[next]){
                hit++;
            } else if(arr2[next] == arr1[next] + 1){
                hit--;
            }
            arr2[prev]--;
            if(arr2[prev] == arr1[prev]){
                hit++;
            } else if(arr2[prev] == arr1[prev] -1) {
                hit--;
            }
        }
        return hit == 26;
    }
}