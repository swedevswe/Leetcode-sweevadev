class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int n = customers.length;
        int totalSatisfied = 0;
        
        for(int i = 0; i<n; i++){
            if(grumpy[i] == 0){
                totalSatisfied += customers[i];
            }
        }
        int potentialGain = 0;
        for(int i = 0; i<minutes; i++){
            if(grumpy[i] == 1){
                potentialGain += customers[i];
            }
        }
        int maxGain = potentialGain;
        
        for(int i = minutes; i<n; i++){
            if(grumpy[i - minutes] == 1){
                potentialGain -= customers[i - minutes];
            }
            if(grumpy[i] == 1){
                potentialGain += customers[i];
            }
            maxGain = Math.max(maxGain, potentialGain);
        }
        return totalSatisfied + maxGain;
    }
}