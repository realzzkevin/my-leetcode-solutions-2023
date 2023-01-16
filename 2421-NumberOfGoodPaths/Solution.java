class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        int n = vals.length;

        TreeMap<Integer, List<Integer>> valuestoNodes = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            valuestoNodes.computeIfAbsent(vals[i], value -> new ArrayList<Integer>()).add(i);
        }

        UnionFind dsu = new UnionFind(n);
        int goodPaths = 0;

        for( int value: valuestoNodes.keySet()){
            for(int node: valuestoNodes.get(value)){
                if(!adj.containsKey(node)){
                    continue;
                }

                for(int neighbor : adj.get(node)){
                    if(vals[node] >= vals[neighbor]){
                        dsu.unionSet(node, neighbor);
                    }
                }
            }

            Map<Integer, Integer> group = new HashMap<>();

            for(int u : valuestoNodes.get(value)){
                group.put(dsu.find(u), group.getOrDefault(dsu.find(u), 0) +1);
            }

            for(int key : group.keySet()){
                int size = group.get(key);
                goodPaths += size * (size + 1) /2;
            }
        }

        return goodPaths;
    }

}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for(int i = 0; i < size; i++) {
            parent[i] = i;
        }
        rank = new int[size];
    }

    public int find(int x){
        if(parent[x] == x) {
            return x;
        }
        else {
            return parent[x] = find(parent[x]);
        }
    }

    public void unionSet(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x == y) {
            return ;
        } else if(rank[x] < rank[y]){
            parent[x] = y;
        } else if(rank[x] > rank[y]){
            parent[y] = x;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
}