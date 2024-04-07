class Solution {
    public boolean checkValidString(String s) {
        int low = 0; int high = 0;
        
        for(char c : s.toCharArray()){
            low += (c=='(') ? 1 : -1;
            low = Math.max(low, 0);
            
            high += (c==')') ? -1 : 1;
            
            if(high<0) return false;
        }
        return low == 0;
    }
}