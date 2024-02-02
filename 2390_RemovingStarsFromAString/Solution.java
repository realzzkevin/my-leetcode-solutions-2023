class Solution {
    // use StringBuffer or Stack
    public String removeStars(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == "*".charAt(0)){
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}