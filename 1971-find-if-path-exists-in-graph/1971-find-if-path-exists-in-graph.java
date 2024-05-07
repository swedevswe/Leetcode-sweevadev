class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination)
            return true;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.add(source);
        visited[source] = true;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            
            
            for(int neighbour : graph.get(current)){
                if(neighbour==destination){
                    return true;
                }
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
            
        }
        return false;
    }
}