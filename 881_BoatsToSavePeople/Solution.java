class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int answer = 0;

        while (left <= right) {
            if(people[right] + people[left] <= limit){
                right--;
                left++;
            } else {
                right--;
            }
            answer++;
        }
        return answer;
    }
}