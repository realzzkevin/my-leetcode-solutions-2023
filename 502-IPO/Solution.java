class Solution {
    class Project {
        int profit, capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (profits.length == 1) {
            if (capital[0] <= w) {
                return profits[0];
            } else {
                return 0;
            }
        }
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }

        Arrays.sort(projects, (a,b) -> a.capital - b.capital);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<Integer>(Collections.reverseOrder());

        int j=0;
        for (int i = 0; i < k; i++) {

            while(j < n && projects[j].capital <= w){
                maxProfit.add(projects[j++].profit);
            }
            if(maxProfit.isEmpty()){
                break;
            }
            w+=maxProfit.poll();
        }

        return w;
    }
}