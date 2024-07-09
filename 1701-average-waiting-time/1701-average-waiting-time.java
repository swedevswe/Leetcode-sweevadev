class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        double totalWaitingTime = 0;
        int currentTime = 0;
        
        for(int[] customer : customers){
            int arrivalTime = customer[0];
            int orderTime = customer[1];
            
            currentTime = Math.max(currentTime, arrivalTime);
            
            currentTime += orderTime;
            
            int waitingTime = currentTime - arrivalTime;
            
            totalWaitingTime += waitingTime;
        }
        return totalWaitingTime / customers.length;
        
    }
}