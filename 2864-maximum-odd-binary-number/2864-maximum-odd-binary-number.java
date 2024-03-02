class Solution {
    public String maximumOddBinaryNumber(String s) {
            int ones = 0;
            int zeros = 0;
            
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                ones++;
            }else{
                zeros++;
            }
        }
        StringBuilder sb = new StringBuilder();
            if(ones==1){
                for(int i = 0; i<zeros; i++){
                    sb.append("0");
                }
                sb.append("1");
            }else{
                for(int i = 0; i<ones-1; i++){
                    sb.append("1");
                }
                for(int i = 0; i<zeros; i++){
                    sb.append("0");
                }
                sb.append("1");
            }
                return sb.toString();
    }
}