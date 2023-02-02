


public class Solution {
	public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1){
            return true;
        }
        Map<Character, Integer> alienDict = new HashMap<>();
        for(int i = 0; i < 26; i++){
            alienDict.put(order.charAt(i), i);
        }
        for(int i = 0; i < words.length - 1; i++ ){
            if(!compareTwoWords(alienDict, words[i], words[i+1])){
                return false;
            }
        }
        return true;
    }

    public boolean compareTwoWords(Map<Character, Integer> dict, String word1, String word2) {
        int n = Math.max(word1.length(), word2.length());
        int i = 0;
        while(i < n) {
            if(i < word1.length() && i < word2.length()){
                if( dict.get(word1.charAt(i)) < dict.get(word2.charAt(i))){
                    return true;
                }
                if(dict.get(word1.charAt(i))> dict.get(word2.charAt(i))){
                    return false;
                }
            } else if(i >= word1.length() && i < word2.length()){
                return true;
            } else if( i >= word2.length() && i < word1.length()){
                return false;
            }
            ++i;
        }

        return true;
    }
}

