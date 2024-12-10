class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int maxLen = -1;
        int n = s.length();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j <= n; j++){
                String sub = s.substring(i, j);
                if(isSpecial(sub)){
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                    if(map.get(sub) >= 3){
                        maxLen = Math.max(maxLen, sub.length());
                    }
                }
            }
        }
        return maxLen;
    }
    private boolean isSpecial(String s){
        char firstChar = s.charAt(0);
        for(char c : s.toCharArray()){
            if(c != firstChar){
                return false;
            }
        }
        return true;
    }
}