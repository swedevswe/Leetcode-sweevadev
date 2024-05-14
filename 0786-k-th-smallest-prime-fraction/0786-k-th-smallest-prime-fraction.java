class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double low = 0.0, high = 1.0, mid;
        
        int[] ans = new int[2];
        
        while(high - low > 1e-9){
            mid = low + (high - low) / 2;
            int count = 0, i = 0;
            double maxFraction = 0.0;
            
            for(int j = 0; j<arr.length; j++){
                while(i<j && arr[i] < mid * arr[j]){
                    i++;
                }
                count += i;
                
                if(i>0){
                    double f = (double) arr[i-1] / arr[j];
                    if(f > maxFraction){
                        maxFraction = f;
                        ans[0] = arr[i-1];
                        ans[1] = arr[j];
                    }
                }
            }
            if(count == k){
                return ans;
            }else if(count < k){
                low = mid;
            }else{
                high = mid;
            }
        }
        return ans;
    }
}