class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        double totalWaitTime = 0;
        int currentTime = 0;
        
        for(int[] customer : customers){
            int arrivalTime = customer[0];
            int orderTime = customer[1];
            
            currentTime = Math.max(currentTime, arrivalTime);
            currentTime += orderTime;
            
            int currWaitTime = currentTime - arrivalTime;
            
            totalWaitTime += currWaitTime;
        }
        return totalWaitTime / customers.length;
    }
}