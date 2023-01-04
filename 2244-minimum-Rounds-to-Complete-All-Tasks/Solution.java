public class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int minRounds = 0;
        List<Integer> list = new ArrayList<>(map.values());
        for(int i = 0; i < list.size(); i++) {
            int steps = findMinSteps(list.get(i));
            if(steps == -1) {
                return -1;
            }
            else {
                minRounds += steps;
            }
        }

        return minRounds;
    }

    public int findMinSteps(int task) {
        if(task == 1) {
            return -1;
        }
        if( task % 3 == 0) {
            return task / 3;
        } else {
            return (task / 3)+1;
        }

    }
}
