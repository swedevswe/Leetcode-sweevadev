class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[]mapS  = new int[256];
        int[] mapT = new int[256];
        
        for(int i = 0; i<256; i++){
            mapS[i] = -1;
            mapT[i] = -1;
        }
        for(int i = 0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if(mapS[c1]!=-1 && mapS[c1]!=c2 || mapT[c2]!=-1 && mapT[c2]!=c1){
                
                return false;
                
            }
            mapS[c1] = c2;
            mapT[c2] = c1;
            
        }
        return true;
    }
}