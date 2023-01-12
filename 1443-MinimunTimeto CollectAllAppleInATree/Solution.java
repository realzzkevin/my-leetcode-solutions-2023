class Solution {
    //try DFS
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        //build map with all edges;
        for(int[] edge: edges ){
            edgeMap.computeIfAbsent(edge[0], value -> new ArrayList<Integer>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], value -> new ArrayList<Integer>()).add(edge[0]);
        }

        dfs(0, -1, set, edgeMap, hasApple);

        return set.size() * 2;
    }

    public boolean dfs(int node, int parent, Set<List<Integer>> set, Map<Integer, List<Integer>> map, List<Boolean> hasApple) {
        boolean foundApple = hasApple.get(node);
        List<Integer> curEdge = new ArrayList<Integer>();
        int a = parent;
        int b = node;
        if(a > b) {
            b = parent;
            a = node;
        }
        curEdge.add(a);
        curEdge.add(b);

        if(map.containsKey(node)){
            for(int nextNode: map.get(node) ) {
                if(nextNode != parent){
                    foundApple = dfs(nextNode, node, set, map, hasApple) || foundApple;
                }
            }
        }

        if(parent != -1 && foundApple){
            set.add(curEdge);
        }
        return foundApple;
    }
}