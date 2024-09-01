class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] List = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            List[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int nodeA = edges[i][0], nodeB = edges[i][1];
            List[nodeA].add(new int[]{nodeB, i});
            List[nodeB].add(new int[]{nodeA, i}); 
        }

        int[][] dist = new int[n][2];
        Arrays.fill(dist[source], 0);
        for (int i = 0; i < n; i++) {
            if (i != source) {
                dist[i][0] = dist[i][1] = Integer.MAX_VALUE;
            }
        }
            djikstra(List, edges, dist, source, 0, 0);
            int diff = target - dist[destination][0];
            if(diff < 0) return new int[][]{};
            djikstra(List, edges, dist, source, diff, 1);
            if(dist[destination][1] < target) return new int[][]{};
                
            for(int[] edge : edges){
                if(edge[2] == -1) edge[2] = 1;
                }
            return edges;
            }

    private void djikstra(List<int[]>[] List, int[][] edges, int[][] dist, int source, int difference, int run) {
        int n = List.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});
        dist[source][run] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];

            if (currDist > dist[currNode][run]) continue;

            for (int[] neighbor : List[currNode]) {
                int nextNode = neighbor[0], edgeIndex = neighbor[1];
                int weight = edges[edgeIndex][2];

                if (weight == -1) weight = 1; // Initially consider -1 as 1

                if (run == 1 && edges[edgeIndex][2] == -1) {
           
                    int newWeight = difference + dist[nextNode][0] - dist[currNode][1];
                    if (newWeight > weight) {
                        edges[edgeIndex][2] = weight = newWeight; 
                    }
                }

                if (dist[nextNode][run] > dist[currNode][run] + weight) {
                    dist[nextNode][run] = dist[currNode][run] + weight;
                    pq.add(new int[]{nextNode, dist[nextNode][run]});
                }
            }
        }
    }
}