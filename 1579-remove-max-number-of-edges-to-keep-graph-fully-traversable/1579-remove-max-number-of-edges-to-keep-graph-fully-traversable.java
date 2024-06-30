class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        //goal is to get Alice and Bob to be able to traverse the entire graph from any node.
        
        //two spanning trees - one for Alice, one for Bob
        
        //union-find data structure (Disjoint Set Union) = helps manage and merge connected components
        //sort and process the edges starting from Type 3, then Type 1 and Type 2.
        //perform union operations = union the nodes for each type of edge. // the core step of the problem
        //checking the connections for fully connected edges for both Alice and Bob
        //returning max number of redundant edges that were found
        //under class UnionFind :
        //parent, rank, count
        //boolean union = u, v, rootU, rootV, find
        //int find
        //boolean isConnected
        
        UnionFind aliceUF = new UnionFind(n);
        UnionFind bobUF = new UnionFind(n);
        
        int edgesUsed = 0;
        
        for(int[] edge : edges){
            if(edge[0] == 3){
                if(aliceUF.union(edge[1], edge[2])){
                    bobUF.union(edge[1], edge[2]);
                    edgesUsed++;
                }
            }
        }
        
        for(int[] edge : edges){
            if(edge[0] == 1){
                if(aliceUF.union(edge[1], edge[2])){
                    edgesUsed++;
                }
            }
        }
        
        for(int[] edge : edges){
            if(edge[0] == 2){
                if(bobUF.union(edge[1], edge[2])){
                    edgesUsed++;
                }
            }
        }
        
        if(aliceUF.isConnected() && bobUF.isConnected()){
            return edges.length - edgesUsed;
        }else{
            return -1;
        }
    }
}

class UnionFind{
    private int[] parent;
    private int[] rank;
    private int count;
    
    public UnionFind(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        count = n;
        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }
    }
    
    public boolean union(int u, int v){
        int rootU = find(u);
        int rootV = find(v);
        
        if(rootU == rootV){
            return false;
        }
        
        if(rank[rootU] > rank[rootV]){
            parent[rootV] = rootU;
        }else if(rank[rootU] < rank[rootV]){
            parent[rootU] = rootV;
        }else{
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        count--;
        return true;
    }
    public int find(int u){
        if(parent[u] != u){
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }
    public boolean isConnected(){
        return count == 1;
    }
}