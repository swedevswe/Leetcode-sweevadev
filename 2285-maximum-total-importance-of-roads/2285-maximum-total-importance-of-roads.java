class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for(int[] road : roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        
        int[][] cityDegree = new int[n][2];
        for(int i = 0; i<n; i++){
            cityDegree[i][0] = i;
            cityDegree[i][1] = degree[i];
        }
        Arrays.sort(cityDegree, (a,b) -> b[1] - a[1]);
        
        int[] values = new int[n];
        for(int i = 0; i<n; i++){
            values[cityDegree[i][0]] = n - i;
            
        }
        long totalImportance = 0;
        for(int[] road : roads){
            totalImportance += values[road[0]] + values[road[1]];
        }
        return totalImportance;
    }
}