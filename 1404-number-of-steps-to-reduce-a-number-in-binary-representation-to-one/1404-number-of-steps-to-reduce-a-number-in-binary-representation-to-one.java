class Solution {
    public int numSteps(String s) {
        int numSteps = 0;
        int carry = 0;
        
        for(int i = s.length()-1; i>0; i--){
            if((s.charAt(i) + carry) % 2 == 0){
                numSteps += 1;
            }else{
                carry = 1;
                numSteps += 2;
            }
        }
        return numSteps + carry;
    }
}