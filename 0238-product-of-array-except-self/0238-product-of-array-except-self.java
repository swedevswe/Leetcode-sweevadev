class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int totalProduct = 1;
        boolean hasZero = false;
        int zeroCount = 0;
        
        for(int i = 0; i<N; i++){
            if(nums[i] != 0){
                totalProduct = totalProduct * nums[i];
            }else{
                hasZero = true;
                zeroCount++;
            }
                
            }
        int[] output_arr = new int[N];
        for(int i = 0; i<N; i++){
        if(zeroCount>1){
            output_arr[i] = 0;
        }else if(hasZero && nums[i]==0){
            output_arr[i] = totalProduct;
        }else if(hasZero){
            output_arr[i] = 0;
        }else{
            output_arr[i] = totalProduct / nums[i];
        }
        }
        return output_arr;
    }
}