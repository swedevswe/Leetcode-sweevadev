class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        List<int[]> result = new ArrayList<>();
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    int[] bounds = {i, j, i, j};
                    dfs(land, i, j, visited, bounds);
                    result.add(new int[] {bounds[0], bounds[1], bounds[2], bounds[3]});
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    private void dfs(int[][] land, int i, int j, boolean[][] visited, int[] bounds){
        int m = land.length, n = land[0].length;
        if(i<0 || i>=m || j<0 || j>=n || land[i][j]==0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        
        bounds[0] = Math.min(bounds[0], i);
        bounds[1] = Math.min(bounds[1], j);
        bounds[2] = Math.max(bounds[2], i);
        bounds[3] = Math.max(bounds[3], j);
        
        dfs(land, i+1, j, visited, bounds);
        dfs(land, i-1, j, visited, bounds);
        dfs(land, i, j+1, visited, bounds);
        dfs(land, i, j-1, visited, bounds);
    }
}