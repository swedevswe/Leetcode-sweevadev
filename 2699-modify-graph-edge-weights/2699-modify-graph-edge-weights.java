class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] List = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            List[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            List[from].add(new int[]{to, i});
            List[to].add(new int[]{from, i}); // Construct graph with edge indices
        }
        int[][] shortestDist = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i != source) {
                shortestDist[i][0] = shortestDist[i][1] = Integer.MAX_VALUE;
            }
        }
        dijkstra(List, edges, shortestDist, source, 0, 0);
        int reqIncr = target - shortestDist[destination][0];
        if (reqIncr < 0) return new int[][]{}; // Not possible to reach the target
        dijkstra(List, edges, shortestDist, source, reqIncr, 1);
        if (shortestDist[destination][1] < target) return new int[][]{}; // Still not possible
        for (int[] edge : edges) {
            if (edge[2] == -1) edge[2] = 1; // Set remaining -1 edges to 1
        }
        return edges;
    }

    private void dijkstra(List<int[]>[] List, int[][] edges, int[][] shortestDist, int start, int reqIncr, int runIndx) {
        int n = List.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{start, 0});
        shortestDist[start][runIndx] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];
            if (currDist > shortestDist[currNode][runIndx]) continue;
            for (int[] neighbor : List[currNode]) {
                int neighborNode = neighbor[0], edgeIndx = neighbor[1];
                int edgeWeight = edges[edgeIndx][2];
                if (edgeWeight == -1) edgeWeight = 1; // Initially consider -1 as 1
                if (runIndx == 1 && edges[edgeIndx][2] == -1) {
                    // Calculate the required weight adjustment for the second run
                    int newWeight = reqIncr + shortestDist[neighborNode][0] - shortestDist[currNode][1];
                    if (newWeight > edgeWeight) {
                        edges[edgeIndx][2] = edgeWeight = newWeight; // Update edge weight
                    }
                }
                if (shortestDist[neighborNode][runIndx] > shortestDist[currNode][runIndx] + edgeWeight) {
                    shortestDist[neighborNode][runIndx] = shortestDist[currNode][runIndx] + edgeWeight;
                    pq.add(new int[]{neighborNode, shortestDist[neighborNode][runIndx]});
                }
            }
        }
    }
}