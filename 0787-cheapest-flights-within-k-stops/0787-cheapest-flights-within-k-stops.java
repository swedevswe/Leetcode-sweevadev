class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        long[] cost = new long[n];
        final long INF = Integer.MAX_VALUE;
        java.util.Arrays.fill(cost, INF);
        cost[src] = 0;
        
        for(int i = 0; i <= k; i++){
            long[] tempCost = cost.clone();
            
            for(int[] flight : flights){
                int from = flight[0], to = flight[1], price = flight[2];
                if(cost[from] < INF){
                    tempCost[to] = Math.min(tempCost[to], cost[from] + price);   
                }
            }
            cost = tempCost; 
        }
        return cost[dst] == INF ? -1 : (int) cost[dst];
        
        
        
        
    }
}