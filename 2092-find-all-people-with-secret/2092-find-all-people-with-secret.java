class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Sort meetings based on their scheduled times for chronological processing.
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        
        // Initialize Union-Find to manage connections between individuals.
        UnionFind uf = new UnionFind(n);
        // Initially, person 0 and firstPerson are connected (know the secret).
        uf.union(0, firstPerson);
        
        // Iterate through meetings, processing those at the same time together.
        int i = 0;
        while (i < meetings.length) {
            int currentTime = meetings[i][2];
            Set<Integer> currentPool = new HashSet<>();
            
            // Union participants of meetings at the current time and track them.
            while (i < meetings.length && meetings[i][2] == currentTime) {
                int[] meeting = meetings[i];
                uf.union(meeting[0], meeting[1]);
                currentPool.add(meeting[0]);
                currentPool.add(meeting[1]);
                i++;
            }
            
            // Reset connections for individuals not connected to person 0 (do not know the secret).
            Set<Integer> toReset = new HashSet<>();
            for (int person : currentPool) {
                if (!uf.isConnected(0, person)) {
                    toReset.add(person);
                }
            }
            toReset.forEach(uf::reset);
        }
        
        // Gather individuals connected to person 0 (know the secret) after all meetings.
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (uf.isConnected(j, 0)) {
                result.add(j);
            }
        }
        return result;
    }
    
    // Union-Find data structure with path compression and union by rank.
    static class UnionFind {
        int[] parent, rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 0);
        }
        
        public int find(int x) {
            if (parent[x] == -1) return x;
            return parent[x] = find(parent[x]);
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        
        // Resets the parent and rank of an individual, indicating disconnection.
        public void reset(int x) {
            parent[x] = -1;
            rank[x] = 0;
        }
    }
}