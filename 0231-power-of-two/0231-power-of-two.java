class Solution {
    public boolean isPowerOfTwo(int n) {
        //bit manipulation
                 return n > 0 && (n & (n-1)) == 0;
    }
}