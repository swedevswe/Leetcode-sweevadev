class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        if(n == 0) return 0;
        
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(sb.length() == 0 || c != sb.charAt(sb.length() - 1)){
                sb.append(c);
            }
        }
        s = sb.toString();
        n = s.length();
        
        int[][] dp = new int[n][n];
        
        for(int len = 1; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                dp[i][j] = (len == 1) ? 1 : dp[i+1][j] + 1;
                
                for(int k = i + 1; k <= j; k++){
                    if(s.charAt(k) == s.charAt(i)){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + (k + 1 <= j ? dp[k + 1][j] : 0));
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}