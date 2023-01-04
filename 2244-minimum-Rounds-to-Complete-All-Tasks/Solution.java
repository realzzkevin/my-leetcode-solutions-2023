public class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            if(map.containsKey(tasks[i])) {
                map.put(tasks[i], map.get(tasks[i])+1);
            } else {
                map.put(tasks[i], 1);
            }
            //map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
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
        // if(task == 2 || task ==3) {
        //     return 1;
        // }

        int n = task/3;
        int m = task%3;

        if(m == 0) {
            return n;
        } else if (m == 2) {
            return n+1;
        } else if (m == 1) {
            if(task>=4) {
                return n+1;
            } else {
                return -1;
            }
        }

        return n;
    }
}
