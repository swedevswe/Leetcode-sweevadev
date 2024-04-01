class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        
        int lastIndex = s.lastIndexOf(' ');
        
        return s.length() - lastIndex - 1;
    }
}