public class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }

        int result = 0;
        int sign = 1;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int index = 0;
        if(s.charAt(0) == '-'){
            sign = -1;
            index++;
        } else if(s.charAt(0) == '+') {
            index++;
        }
        while(index <s.length() && Character.isDigit(s.charAt(index))) {
            int temp = Character.getNumericValue(s.charAt(index));
            if(sign >= 0 && (result > (max/10) || (result == (max/10) && temp > (max % 10)))) {
                return max;
            } else if( (sign * result) < (min/10) || ((sign * result) == (min/10) && (sign * temp) < (min % 10))) {
                return min;
            }
            result = (result * 10) + temp;

            index++;
        }

        return result*sign;

    }
}
