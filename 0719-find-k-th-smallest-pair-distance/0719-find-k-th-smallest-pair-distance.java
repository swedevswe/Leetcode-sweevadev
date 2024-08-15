class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int n = nums.length, left = 0, right = nums[n-1] - nums[0];
      
        while(left < right){
            int mid = left + (right - left) / 2;
            int count = countPairs(nums, mid);
            
            if(count < k){
                left = mid + 1;
               
            }else{
                 right = mid;
            }
            
        }
        return left;
    }
    private int countPairs(int[] nums, int distance){
        int count = 0, left = 0;
        
        for(int right = 0; right < nums.length; right++){
            while(nums[right] - nums[left] > distance){
                left++;
            }
            count += right - left;
            
        }
        return count;
    }
}