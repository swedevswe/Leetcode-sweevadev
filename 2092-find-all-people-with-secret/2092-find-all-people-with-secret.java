class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // List to store the final answer.
        List<Integer> ans = new ArrayList<>();
        // Set to keep track of people who have been added to the answer list.
        Set<Integer> added = new HashSet<>();
        
        // Priority queue to process people in the order they learn the secret.
        PriorityQueue<int[]> known = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        known.offer(new int[]{0, 0}); // Person 0 knows the secret at time 0.
        known.offer(new int[]{firstPerson, 0}); // firstPerson knows the secret at time 0.
        
        // Map to store meetings for each person.
        Map<Integer, List<int[]>> meetingsMap = new HashMap<>();
        for (int[] meeting : meetings) {
            meetingsMap.computeIfAbsent(meeting[0], k -> new ArrayList<>()).add(new int[]{meeting[1], meeting[2]});
            meetingsMap.computeIfAbsent(meeting[1], k -> new ArrayList<>()).add(new int[]{meeting[0], meeting[2]});
        }
        
        // Process each person in the priority queue.
        while (!known.isEmpty()) {
            int[] current = known.poll();
            
            // Add the person to the answer list if not already added.
            if (added.add(current[0])) {
                ans.add(current[0]);
            }
            
            // Skip if there are no meetings for the current person.
            if (!meetingsMap.containsKey(current[0])) continue;
            
            // Process meetings for the current person.
            for (int[] meeting : meetingsMap.get(current[0])) {
                // Skip if the meeting occurred before the person knew the secret.
                if (meeting[1] < current[1]) continue;
                
                // Add the person they met with to the queue.
                known.offer(new int[]{meeting[0], meeting[1]});
            }
            
            // Remove the person from the map to avoid reprocessing.
            meetingsMap.remove(current[0]);
        }

        return ans;
    }
}