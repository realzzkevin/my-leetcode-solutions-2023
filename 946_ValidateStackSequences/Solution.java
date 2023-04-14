class Solution {
    public boolean validateStackSequences(int[] pushed, int [] poped) {
        Stack<Integer> stack = new stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == poped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}