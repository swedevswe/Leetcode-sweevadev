class Solution {
    public int takeCharacters(String s, int k) {
        int[] totalCount = new int[3];
        for(char c : s.toCharArray()){
            totalCount[c - 'a']++;
        }
        if(totalCount[0] < k || totalCount[1] < k || totalCount[2] < k){
            return -1;
        }
        int n = s.length();
        int[] windowCount = new int[3];
        int start = 0, maxWindowSize = 0;
        for(int end = 0; end < n; end++){
            windowCount[s.charAt(end) - 'a']++;
            while(windowCount[0] > totalCount[0] - k || windowCount[1] > totalCount[1] - k || windowCount[2] > totalCount[2] - k){
                windowCount[s.charAt(start) - 'a']--;
                start++;
            }
            maxWindowSize = Math.max(maxWindowSize, end - start + 1);
        }
        return n - maxWindowSize;
    }
}