class Solution {
    public boolean validWordSquare(List<String> words) {
        if(words.get(0).length() != words.size()){
            return false;
        }
        for(String s : words) {
            if(words.size() < s.length()){
                return false;
            }
        }
        for(int i = 0; i < words.size(); i++) {
            for(int j = i; j < words.size(); j++ ){
                char temp1 = ' ';
                char temp2 = ' ';
                if(j < words.get(i).length()) {
                    temp1 = words.get(i).charAt(j);
                }
                if(i < words.get(j).length()){
                    temp2 = words.get(j).charAt(i);
                }
                if(temp1 != temp2) {
                    return false;
                }
            }

        }
        return true;
    }
}