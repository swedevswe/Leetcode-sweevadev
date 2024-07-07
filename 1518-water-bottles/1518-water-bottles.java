class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total_drunk = 0;
        int empty_bottles = 0;
        
        total_drunk += numBottles;
        empty_bottles += numBottles;
        
        while(empty_bottles >= numExchange){
            int new_full_bottles = empty_bottles / numExchange;
            total_drunk += new_full_bottles;
            empty_bottles = empty_bottles % numExchange + new_full_bottles;
            
        }
        return total_drunk;
    }
}