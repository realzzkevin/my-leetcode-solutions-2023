public class Solution {
    public boolean detectCapitalUse(String word) {

        if(word.charAt(0) >= 'A' && word.charAt(0) <='Z') {
            if(word.length() > 1 && (word.charAt(1) >='a' && word.charAt(1) <='z')) {
                for(int i = 1; i < word.length(); i++) {
                    if(word.charAt(i) < 'a' || word.charAt(i) > 'z'){
                        return false;
                    }
                }
            } else {
                for(int i = 1; i < word.length(); i++) {
                    if(word.charAt(i) < 'A' || word.charAt(i) > 'Z') {
                        return false;
                    }
                }
            }
        } else {
            for(int i = 1; i < word.length(); i++) {
                if(word.charAt(i) < 'a' || word.charAt(i) > 'z'){
                    return false;
                }
            }
        }

        return true;
    }
}
