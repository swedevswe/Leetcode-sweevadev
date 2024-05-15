class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        int[][] distance = new int[n][n];
        for(int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        
     
        Queue<int[]> queue = new LinkedList<>();
        
        for(int r = 0; r<n; r++){
            for(int c = 0; c<n; c++){
                if(grid.get(r).get(c)==1){
                    queue.offer(new int[]{r,c});
                    distance[r][c] = 0;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for(int[] dir : directions){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && distance[nx][ny] == Integer.MAX_VALUE){
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        int low = 0, high = n - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(canReachSafenessFactor(distance, n, directions, mid)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
        
        
        
        
    }
    private boolean canReachSafenessFactor(int[][] distance, int n, int[][] directions, int safenessFactor){
        if(distance[0][0] < safenessFactor) return false;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            if(x==n-1 && y==n-1) return true;
            
            for(int[] dir : directions){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && nx < n && ny >=0 && ny < n && !visited[nx][ny] && distance[nx][ny] >= safenessFactor){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny});
                }
                
            }
        }
        return false;
    }
}