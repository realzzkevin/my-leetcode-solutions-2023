public class Solution {
	public String gcdOfStrings(String str1, String str2) {
        if(str1.equals(str2)) {
            return str1;
        }
        if(str2.length() > str1.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int n1 = str1.length();
        int n2 = str2.length();
        int div = 1;
        while(div <= n2) {
            if(n2 % div == 0) {
                int a = n2/div;
                if(n1 % a == 0 && helper(a, str1, str2)) {
                    return str1.substring(0, a);
                }
            }
            div++;
        }
        return "";        
    }

    public boolean helper(int n, String a, String b) {
        int start = 0;
        int end = n;
        String subStr = b.substring(start, end);
        while(end <= a.length()){
            if(end <= b.length() && !subStr.equals(b.substring(start, end))){
                return false;
            }
            if(!subStr.equals(a.substring(start, end))){
                return false;
            }
            start += n;
            end += n;
        }
        return true;
    }
	
}
