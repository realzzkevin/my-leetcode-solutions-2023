class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> answer = new ArrayList<Integer>();
        int carry = 0;
        int i = num.length - 1;
        while(i >= 0 || k > 0) {
            if(i >=0) {
                carry += num[i] + (k%10);
                i--;
            } else {
                carry += (k%10);
            }
            answer.add(carry%10);
            carry /= 10;
            k /= 10;
        }
        if(carry != 0) {
            answer.add(carry);
        }
        List<Integer> newAnswer = new ArrayList<Integer>();
        for(i = answer.size() - 1; i >= 0; i--) {
            newAnswer.add(answer.get(i));
        }
        return newAnswer;

    }
}