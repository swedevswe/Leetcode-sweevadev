class Solution {
    public int findTheWinner(int n, int k) {
        //Josephus Problem
        //recursive or iterative elimination based on counting in a circular motion
        
        int winner = 0;
        
        for(int i = 2; i<=n; i++){
            winner = (winner + k) % i;
        }
        return winner + 1;
    }
}