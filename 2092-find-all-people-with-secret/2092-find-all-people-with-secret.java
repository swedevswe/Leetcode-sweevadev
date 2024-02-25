class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Sort meetings by time to ensure chronological processing.
        Map<Integer, List<Integer>> meetingsByTime = new TreeMap<>();
        for (int i = 0; i < meetings.length; i++) {
            meetingsByTime.computeIfAbsent(meetings[i][2], k -> new ArrayList<>()).add(i);
        }
        
        // Initialize Union-Find structure for tracking connections.
        UnionFind uf = new UnionFind(n);
        // Initially, person 0 and firstPerson are connected, meaning they know the secret.
        uf.union(0, firstPerson);
        
        // Process each set of meetings occurring at the same time.
        for (int time : meetingsByTime.keySet()) {
            Set<Integer> currentPool = new HashSet<>();
            
            // Union everyone involved in the current time slot's meetings.
            for (int index : meetingsByTime.get(time)) {
                int[] meeting = meetings[index];
                uf.union(meeting[0], meeting[1]);
                currentPool.add(meeting[0]);
                currentPool.add(meeting[1]);
            }
            
            // If a person in the current pool isn't connected to 0, reset their connection.
            // This implies they don't know the secret after this round of meetings.
            for (int person : currentPool) {
                if (!uf.isConnected(0, person)) {
                    uf.reset(person);
                }
            }
        }
        
        // Collect and return all people connected to 0, as they know the secret.
        List<Integer> peopleWhoKnowSecret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uf.isConnected(i, 0)) {
                peopleWhoKnowSecret.add(i);
            }
        }
        return peopleWhoKnowSecret;
    }
    
    class UnionFind {
        int[] parent, rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i; // Initially, everyone is their own parent.
                rank[i] = 0; // Initial rank of trees is 0.
            }
        }
        
        public int find(int person) {
            if (person != parent[person]) {
                parent[person] = find(parent[person]); // Path compression.
            }
            return parent[person];
        }
        
        public void union(int person1, int person2) {
            int root1 = find(person1);
            int root2 = find(person2);
            if (root1 != root2) {
                if (rank[root1] < rank[root2]) {
                    parent[root1] = root2;
                } else if (rank[root1] > rank[root2]) {
                    parent[root2] = root1;
                } else {
                    parent[root2] = root1;
                    rank[root1]++;
                }
            }
        }
        
        public boolean isConnected(int person1, int person2) {
            return find(person1) == find(person2);
        }
        
        public void reset(int person) {
            parent[person] = person;
            rank[person] = 0;
        }
    }
}