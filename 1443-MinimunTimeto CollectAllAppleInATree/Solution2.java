class Solution {
    //try DFS
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();

        for(int[] edge: edges ){
            edgeMap.computeIfAbsent(edge[0], value -> new ArrayList<Integer>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], value -> new ArrayList<Integer>()).add(edge[0]);
        }

        return dfs(0, -1, edgeMap, hasApple);
    }

    public int dfs(int node, int parent, Map<Integer, List<Integer>> map, List<Boolean> hasApple) {

        int totalTime = 0;
        if(map.containsKey(node)){
            for(int nextNode: map.get(node) ) {
                if(nextNode != parent){
                    int childTime = dfs(nextNode, node, map, hasApple);
                    if(childTime > 0 || hasApple.get(nextNode))  {
                        totalTime += childTime+2;
                    }
                }
            }
        }

        return totalTime;
    }
}