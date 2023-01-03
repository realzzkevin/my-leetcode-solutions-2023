public class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int result = 0;
        int positive = 1;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        System.out.println(max);
        System.out.println(min);
        int index = 0;
        if(s.charAt(0) == '-'){
            positive = -1;
            index++;
        } else if(s.charAt(0) == '+') {
            index++;
        }
        while(index <s.length() && Character.isDigit(s.charAt(index))) {
            result = (result * 10) + Character.getNumericValue(s.charAt(index));
            index++;
        }
        return result*positive;

    }
}
