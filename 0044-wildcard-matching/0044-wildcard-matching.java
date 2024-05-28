class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        int sPointer = 0, pPointer = 0;
        
        int starIndex = -1, sTempIndex = -1;
        
        while(sPointer < m){
            if(pPointer < n && (p.charAt(pPointer) == s.charAt(sPointer) || p.charAt(pPointer) == '?')){
                sPointer++;
                pPointer++;
            }
            else if(pPointer < n && p.charAt(pPointer) == '*') {
                starIndex = pPointer;
                sTempIndex = sPointer;
                pPointer++;
            }
            else if(starIndex != -1){
                pPointer = starIndex + 1;
                sTempIndex++;
                sPointer = sTempIndex;
            }
            else{
                return false;
            }
        }
        while(pPointer < n && p.charAt(pPointer) == '*'){
            pPointer++;
        }
        return pPointer == n;
        
        
    }
}