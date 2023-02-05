class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()){
            return new ArrayList<Integer>();
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < p.length(); i++) {
            arr1[p.charAt(i) - 'a']++;
            arr2[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(arr1[i] == arr2[i]){
                count++;
            }
        }
        if(count == 26) {
            result.add(0);
        }

        for(int i = 0; i < s.length() - p.length(); i++) {
            int prev = s.charAt(i) - 'a';
            int next = s.charAt(i+p.length()) - 'a';

            arr2[prev]--;
            if(arr2[prev] == arr1[prev]){
                count++;
            } else if(arr2[prev] == arr1[prev] - 1) {
                count--;
            }

            arr2[next]++;
            if(arr2[next] == arr1[next]){
                count++;
            } else if(arr2[next] == arr1[next] + 1) {
                count--;
            }

            if(count == 26) {
                result.add(i+1);
            }

        }

        return result;
    }
}