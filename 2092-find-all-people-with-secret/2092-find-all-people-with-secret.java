class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[2], b[2]));
        
        UnionFind uf = new UnionFind(n);
        uf.union(0, firstPerson);
     
        List<int[]> currentMeetings = new ArrayList<>();
        int i = 0;
        while(i<meetings.length){
            int currentTime = meetings[i][2];
            currentMeetings.clear();
            
        while(i<meetings.length && meetings[i][2]==currentTime){
            currentMeetings.add(meetings[i]);
            i++;
        }
            for(int[] meeting : currentMeetings){
                uf.union(meeting[0], meeting[1]);
            }
            Set<Integer> participants = new HashSet<>();
            for(int[] meeting : currentMeetings){
                if(uf.connected(meeting[0], 0)){
                    participants.add(meeting[0]);
                }if(uf.connected(meeting[1],0)){
                    participants.add(meeting[1]);
                }
            }
            for(int[] meeting : currentMeetings){
                if(!participants.contains(meeting[0])) uf.reset(meeting[0]);
                if(!participants.contains(meeting[1])) uf.reset(meeting[1]);
                
            }
            for(int participant : participants){
                uf.union(0, participant);
            }
            
        }
        List<Integer> ans = new ArrayList<>();
       for( int j = 0; j<n; j++){
           if(uf.connected(j,0)){
               ans.add(j);
           }
       }
        return ans;
    }
    class UnionFind{
        int[] parent;
        int[] rank;
    public UnionFind(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i=0; i<size; i++){
            parent[i] = i;
            rank[i] = 0;
            
        }
    }
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
    public void reset(int x){
        parent[x] = x;
        rank[x] = 0;
    }
    }
}