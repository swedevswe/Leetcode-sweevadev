class Solution {
    public int[][] findFarmland(int[][] land) {
        
        List<int[]> results = new ArrayList<>();
        int m = land.length, n = land[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    int[] bounds = {i, j, i, j};
                    dfs(land, i, j, visited, bounds);
                    results.add(new int[] {bounds[0], bounds[1], bounds[2], bounds[3]});
                }
            }
        }
        return results.toArray(new int[results.size()][]);
        
        
    }
    private void dfs(int[][] land, int r, int c, boolean[][] visited, int[] bounds){
        int m = land.length;
        int n = land[0].length;
        
        if(r<0 || r>=m || c<0 || c>=n || visited[r][c] || land[r][c] == 0){
            return;
        }
        visited[r][c] = true;
        
        bounds[0] = Math.min(bounds[0],r);
        bounds[1] = Math.min(bounds[1],c);
        bounds[2] = Math.max(bounds[2],r);
        bounds[3] = Math.max(bounds[3],c);
        
        dfs(land, r+1, c, visited, bounds);
        dfs(land, r-1, c, visited, bounds);
        dfs(land, r, c+1, visited, bounds);
        dfs(land, r, c-1, visited, bounds);
    }
}