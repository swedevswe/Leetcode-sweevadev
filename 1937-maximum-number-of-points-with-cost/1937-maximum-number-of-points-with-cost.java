class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] dp = new long[n];

        // Initialize dp with the first row values
        for (int j = 0; j < n; ++j) {
            dp[j] = points[0][j];
        }

        // Process each row from the second row onward
        for (int i = 1; i < m; ++i) {
            long[] newDp = new long[n];
            long leftMax = dp[0];

            // Update dp from left to right
            for (int j = 0; j < n; ++j) {
                if (j > 0) {
                    leftMax = Math.max(leftMax, dp[j] + j);
                }
                newDp[j] = points[i][j] + leftMax - j;
            }

            long rightMax = dp[n-1] - (n-1);

            // Update dp from right to left
            for (int j = n-1; j >= 0; --j) {
                if (j < n-1) {
                    rightMax = Math.max(rightMax, dp[j] - j);
                }
                newDp[j] = Math.max(newDp[j], points[i][j] + rightMax + j);
            }

            dp = newDp;  // Update dp array for the next row
        }

        // Find the maximum value in the dp array
        long maxPoints = 0;
        for (long point : dp) {
            maxPoints = Math.max(maxPoints, point);
        }

        return maxPoints;
    }
}
