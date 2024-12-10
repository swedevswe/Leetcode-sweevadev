class Solution {
    public int maximumLength(String s) {
        Map<Pair<Character, Integer>, Integer> count = new HashMap<>();
        int subLen = 0;
        for(int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            subLen = 0;
            for(int j = i; j < s.length(); j++){
                if(character == s.charAt(j)){
                    subLen++;
                    Pair<Character, Integer> key = new Pair<>(character, subLen);
                    count.put(key, count.getOrDefault(key, 0) + 1);
                }else{
                    break;
                }
            }
        }
        int ans = 0;
        for(Map.Entry<Pair<Character, Integer>, Integer> entry : count.entrySet()){
            int len = entry.getKey().getValue();
            if(entry.getValue() >= 3 && len > ans){
                ans = len;
            }
        }
        return ans == 0 ? -1 : ans;
    }
}

