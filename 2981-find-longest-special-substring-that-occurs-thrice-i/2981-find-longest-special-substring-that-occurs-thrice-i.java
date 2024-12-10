class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        for(int len = n; len >= 1; len--){
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i <= n - len; i++){
                String sub = s.substring(i, i + len);
                if(isSpecial(sub)){
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                    if(map.get(sub) >= 3){
                        return len;
                    }
                }
            }
        }
        return -1;
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