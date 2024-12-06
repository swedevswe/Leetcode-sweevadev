class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for(int num : banned){
            bannedSet.add(num);
        }
        int currSum = 0;
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(bannedSet.contains(i)){
                continue;
            }
            if(currSum + i > maxSum){
                break;
            }
            currSum += i;
            count++;
        }
        return count;
    }
}