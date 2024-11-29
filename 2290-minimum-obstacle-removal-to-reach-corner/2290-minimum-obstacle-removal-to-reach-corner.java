class Solution {
    public int minimumObstacles(int[][] grid) {
        //modified BFS with pq.
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for(int[] row : cost){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0,0});
        cost[0][0] = 0;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!dq.isEmpty()){
            int[] cell = dq.pollFirst();
            int row = cell[0];
            int col = cell[1];
            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n){
                    int newCost = cost[row][col] + grid[newRow][newCol];
                    if(newCost < cost[newRow][newCol]){
                        cost[newRow][newCol] = newCost;
                        if(grid[newRow][newCol] == 0){
                            dq.addFirst(new int[]{newRow, newCol});
                        }else{
                            dq.addLast(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }
                       return cost[m-1][n-1];
    }
}