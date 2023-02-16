class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        char c = '0';
        int i = a.length() - 1;
        int j = b.length() - 1;

        while(i >= 0 || j >= 0) {
            char aChar = '0';
            char bChar = '0';
            char temp = '0';
            if(i >= 0){
                aChar = a.charAt(i);
                i--;
            }
            if(j >= 0){
                bChar = b.charAt(j);
                j--;
            }
            if(aChar == c){
                if(c == '1'){
                    temp = '0';
                }
            } else {
                temp = '1';
                c = '0';
            }

            if(bChar == temp){
                if(temp == '1'){
                    temp = '0';
                    c = '1';
                }
            } else {
                temp = '1';
            }

            str.append(temp);
        }

        if(c == '1'){
            str.append(c);
        }

        return str.reverse().toString();
    }
}