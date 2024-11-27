class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        //city = nodes
        //roads = directed edges
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n - 1; i++){
            graph.get(i).add(i + 1);
        }
        int[] result = new int[queries.length];
        for(int q = 0; q < queries.length; q++){
            int u = queries[q][0];
            int v = queries[q][1];
            graph.get(u).add(v);
            result[q] = bfs(graph, n);
        }
        return result;
    }
    private int bfs(List<List<Integer>> graph, int n){
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        que.add(0);
        visited[0] = true;
        while(!que.isEmpty()){
            int current = que.poll();
            for(int neighbour : graph.get(current)){
                if(!visited[neighbour]){
                    que.add(neighbour);
                    visited[neighbour] = true;
                    distance[neighbour] = distance[current] + 1;
                    if(neighbour == n - 1){
                        return distance[neighbour];
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}