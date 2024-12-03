class Solution {
    public String addSpaces(String s, int[] spaces) {
        int total = s.length() + spaces.length;
        char[] result = new char[total];
        int sPointer = 0, spacePointer = 0, resultPointer = 0;
        while(sPointer < s.length()){
            if(spacePointer < spaces.length && sPointer == spaces[spacePointer]){
                result[resultPointer++] = ' ';
                spacePointer++;
            }
            result[resultPointer++] = s.charAt(sPointer++);
        }
        return new String(result);
    }
}