class Solution {
    int[] result;
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        result = new int[n];
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            map.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            map.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        map.get(0);

        dfs(0, -1, labels);

        return result;
    }

    public int[] dfs(int node, int parent, String labels){
        int[] table = new int[26];
        table[labels.charAt(node) - 'a']++;
        if(!map.containsKey(node)) {
            return table;
        }

        for(Integer next : map.get(node)) {
            if(next == parent){
                continue;
            }
            int[] temp = dfs(next, node, labels);
            for(int i = 0; i < 26; i++) {
                table[i] += temp[i];
            }
        }
        result[node] = table[labels.charAt(node)-'a'];
        return table;
    }
}