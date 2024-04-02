class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charCount = new HashMap<>();
        
        char c = 'a';
        
        for(int i = 0; i<s.length(); i++){
            if(charCount.containsKey(s.charAt(i))){
                c= charCount.get(s.charAt(i));
                if(c!=t.charAt(i))
                    return false;
            }else if(!charCount.containsValue(t.charAt(i))){
                charCount.put(s.charAt(i),t.charAt(i));
            }
            else{
                return false;
            }
        }
        return true;
    }
}