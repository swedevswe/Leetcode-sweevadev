class Solution {
    public int[][] modifiedGraphEdges(int nodeCount, int[][] edges, int sourceNode, int destinationNode, int targetDistance) {
        List<int[]>[] adjacencyList = new ArrayList[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int fromNode = edges[i][0], toNode = edges[i][1];
            adjacencyList[fromNode].add(new int[]{toNode, i});
            adjacencyList[toNode].add(new int[]{fromNode, i}); // Construct graph with edge indices
        }
        int[][] shortestDistances = new int[nodeCount][2];
        for (int i = 0; i < nodeCount; i++) {
            if (i != sourceNode) {
                shortestDistances[i][0] = shortestDistances[i][1] = Integer.MAX_VALUE;
            }
        }
        dijkstra(adjacencyList, edges, shortestDistances, sourceNode, 0, 0);
        int requiredIncrease = targetDistance - shortestDistances[destinationNode][0];
        if (requiredIncrease < 0) return new int[][]{}; // Not possible to reach the target
        dijkstra(adjacencyList, edges, shortestDistances, sourceNode, requiredIncrease, 1);
        if (shortestDistances[destinationNode][1] < targetDistance) return new int[][]{}; // Still not possible
        for (int[] edge : edges) {
            if (edge[2] == -1) edge[2] = 1; // Set remaining -1 edges to 1
        }
        return edges;
    }

    private void dijkstra(List<int[]>[] adjacencyList, int[][] edges, int[][] shortestDistances, int startNode, int requiredIncrease, int runIndex) {
        int nodeCount = adjacencyList.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.add(new int[]{startNode, 0});
        shortestDistances[startNode][runIndex] = 0;
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentDistance = current[1];
            if (currentDistance > shortestDistances[currentNode][runIndex]) continue;
            for (int[] neighbor : adjacencyList[currentNode]) {
                int neighborNode = neighbor[0], edgeIndex = neighbor[1];
                int edgeWeight = edges[edgeIndex][2];
                if (edgeWeight == -1) edgeWeight = 1; // Initially consider -1 as 1
                if (runIndex == 1 && edges[edgeIndex][2] == -1) {
                    // Calculate the required weight adjustment for the second run
                    int newWeight = requiredIncrease + shortestDistances[neighborNode][0] - shortestDistances[currentNode][1];
                    if (newWeight > edgeWeight) {
                        edges[edgeIndex][2] = edgeWeight = newWeight; // Update edge weight
                    }
                }
                if (shortestDistances[neighborNode][runIndex] > shortestDistances[currentNode][runIndex] + edgeWeight) {
                    shortestDistances[neighborNode][runIndex] = shortestDistances[currentNode][runIndex] + edgeWeight;
                    minHeap.add(new int[]{neighborNode, shortestDistances[neighborNode][runIndex]});
                }
            }
        }
    }
}