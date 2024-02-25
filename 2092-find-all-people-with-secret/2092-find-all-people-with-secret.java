class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Initialize the groups array to keep track of each person's group.
        int[] groups = new int[n];
        for (int i = 0; i < n; ++i) groups[i] = i;
        // Initially, firstPerson is in the same group as person 0 (they share the secret).
        groups[firstPerson] = 0;

        // Sort the meetings by their time to process them in chronological order.
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

        // Temporary list to keep track of participants in the current time slot.
        List<Integer> currentMeetingParticipants = new ArrayList<>();

        int i = 0;
        while (i < meetings.length) {
            int currentTime = meetings[i][2];
            currentMeetingParticipants.clear();

            // Process all meetings that occur at the current time.
            while (i < meetings.length && meetings[i][2] == currentTime) {
                int personA = meetings[i][0];
                int personB = meetings[i][1];

                // Find the groups of the two meeting participants.
                int groupA = findGroup(groups, personA);
                int groupB = findGroup(groups, personB);

                // Union the groups by updating the group of the higher-indexed person to the lower one.
                groups[Math.max(groupA, groupB)] = Math.min(groupA, groupB);

                // Add participants to the temporary list.
                currentMeetingParticipants.add(personA);
                currentMeetingParticipants.add(personB);

                ++i;
            }

            // Reset the group of any participant who is not in group 0 after the meetings.
            for (int participant : currentMeetingParticipants) {
                if (findGroup(groups, participant) != 0) {
                    groups[participant] = participant;
                }
            }
        }

        // Compile the list of people who are in group 0 (know the secret) after all meetings.
        List<Integer> peopleWhoKnowSecret = new ArrayList<>();
        for (int j = 0; j < n; ++j) {
            if (findGroup(groups, j) == 0) {
                peopleWhoKnowSecret.add(j);
            }
        }

        return peopleWhoKnowSecret;
    }

    // Helper method to find the group of a person using path compression.
    private int findGroup(int[] groups, int person) {
        if (person != groups[person]) {
            groups[person] = findGroup(groups, groups[person]);
        }
        return groups[person];
    }
}