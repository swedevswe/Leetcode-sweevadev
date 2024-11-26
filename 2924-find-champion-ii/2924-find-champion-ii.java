class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        for(int[] edge : edges){
            int strongTeam = edge[0];
            int weakTeam = edge[1];
            inDegree[weakTeam]++;
        }
        int champ = -1;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                count++;
                if(count > 1){
                    return -1;
                }
                champ = i;
            }
        }
        return (count == 1) ? champ : -1;
    }
}