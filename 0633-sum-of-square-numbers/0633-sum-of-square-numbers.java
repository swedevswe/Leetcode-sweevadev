class Solution {
    public boolean judgeSquareSum(int c) {
        for(int a = 0; a<=Math.sqrt(c); a++){
            int a2 = a*a;
            int b2 = c - a2;
            if(isPerfectSquare(b2)){
                return true;
            }
        }
        return false;
        
    }
    private boolean isPerfectSquare(int n){
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}