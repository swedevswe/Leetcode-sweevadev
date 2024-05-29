class Solution {
    public int numSteps(String s) {
        int numSteps = 0;
        
        //right to left
        //apply the rules : add 1 if odd and divide by 2 if even
        
        int carry = 0;
        
        int length = s.length();
        
        for(int i = length - 1; i>0; i--){
            if((s.charAt(i) - '0' + carry) % 2 == 0){
                numSteps += 1;
            }else{
                carry = 1;
                numSteps += 2;
            }
        }
        return numSteps + carry;
    }
}