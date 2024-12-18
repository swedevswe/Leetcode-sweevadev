class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++){
            int discount = 0;
            for(int j = i + 1; j < n; j++){
                if(prices[j] <= prices[i]){
                    discount = prices[j];
                    break;
                }
            }
            ans[i] = prices[i] - discount;
        }
        return ans;
    }
}