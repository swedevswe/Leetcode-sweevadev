class Solution {
    public int findIntegers(int n) {
        int fib[] = new int[32];
        fib[0] = 1;
        fib[1] = 2;
        
        for(int i = 2; i<32; i++){
            fib[i] = fib[i-1] + fib[i-2];   
        }
        int result = 0;
        int k = 30;
        
        boolean prev_bit_one = false;
        while(k>=0){
            if((n&(1<<k))!=0){
                result += fib[k];
                if(prev_bit_one){
                    result--;
                    break;
                }prev_bit_one = true;
            }else{
                    prev_bit_one = false;
                }
                k--;
            }
            return result + 1;
        }
        
    }
