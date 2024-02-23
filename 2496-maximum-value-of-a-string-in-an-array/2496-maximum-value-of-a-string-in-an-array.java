class Solution {
    public int maximumValue(String[] strs) {
            int maxVal = 0;
        for(String str : strs){
            int value;
            if(str.matches("\\d+")){
                value = Integer.parseInt(str);
            }else{
                value = str.length();
            }
            maxVal = Math.max(maxVal, value);
        }
        return maxVal;
        }
}