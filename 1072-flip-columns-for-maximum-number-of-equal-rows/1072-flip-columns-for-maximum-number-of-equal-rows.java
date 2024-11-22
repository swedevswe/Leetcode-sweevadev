class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int maxRows = 0;

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            StringBuilder complement = new StringBuilder();

            // Build both the pattern and its complement
            for (int val : row) {
                pattern.append(val);          // Original row
                complement.append(1 - val);   // Complement row
            }

            String normalisedPattern = pattern.toString();
            String normalisedComplement = complement.toString();

            // Use either the pattern or its complement, whichever is canonical
            String key = normalisedPattern.compareTo(normalisedComplement) <= 0 
                         ? normalisedPattern 
                         : normalisedComplement;

            // Increment counts for the chosen key
            map.put(key, map.getOrDefault(key, 0) + 1);

            // Update the maximum rows that can be made uniform
            maxRows = Math.max(maxRows, map.get(key));
        }

        return maxRows;
    }
}
