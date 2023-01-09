class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        if(strs.length == 1) {
            anagrams.add(new ArrayList<String>(Arrays.asList(strs)));
            return anagrams;
        }

        String[] strList = new String[strs.length];
        for( int i = 0; i < strs.length; i++) {
            strList[i] = findCode(strs[i]);
        }

        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strList.length; i++) {
            if(map.containsKey(strList[i])){
                map.get(strList[i]).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(strList[i], temp);
            }
        }
        anagrams.addAll(map.values());

        return anagrams;

    }

    public String findCode(String s) {
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        String str = "";

        for(int n : alphabet){
            str += "/"+n;
        }
        return str;
    }


}