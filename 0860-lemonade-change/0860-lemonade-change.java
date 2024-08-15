class Solution {
    public boolean lemonadeChange(int[] bills) {
        //keep track of 5 dollars and 10 dollars 
        //initialise counters
        //process each bill
        //check for sufficient change
        //return result
        
        int five = 0, ten = 0;
        
        for(int bill : bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){
                if(five == 0){
                    return false;
                }
                five--;
                ten++;
            }else{
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}