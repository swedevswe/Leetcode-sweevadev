class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0;
        int currentTime = 0;
        
        for(int[] customer : customers){
            int arrivalTime = customer[0];
            int orderTime = customer[1];
            
            currentTime = Math.max(currentTime, arrivalTime);
            
            currentTime += orderTime;
            
            int currWaitTime = currentTime - arrivalTime;
            
            totalWaitingTime += currWaitTime;
        }
        return totalWaitingTime / customers.length;
    }
}