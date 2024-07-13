class Solution {
    public int maximumGain(String s, int x, int y) {
        
        if(x < y){
            int scoreBaFirst = calculatePoints(s, 'b', 'a', y);
            String remainderBa = removeProcessed(s, 'b', 'a');
            return scoreBaFirst + calculatePoints(remainderBa, 'a', 'b', x);
        }else{
            int scoreAbFirst = calculatePoints(s, 'a', 'b', x);
            String remainderAb = removeProcessed(s, 'a', 'b');
            return scoreAbFirst + calculatePoints(remainderAb, 'b', 'a', y);
        }
    }
    private int calculatePoints(String s, char first, char second, int points){
        int score = 0;
        
        StringBuilder remainder = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(c == second && remainder.length() > 0 && remainder.charAt(remainder.length() - 1) == first){
                remainder.deleteCharAt(remainder.length() - 1);
                score += points;
            }
            else{
                remainder.append(c);
            }
        }
        return score;
    }
    private String removeProcessed(String s, char first, char second){
        StringBuilder remainder = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(c == second && remainder.length() > 0 && remainder.charAt(remainder.length() - 1) == first){
                remainder.deleteCharAt(remainder.length() - 1);
            }else{
                remainder.append(c);
            }
        }
        return remainder.toString();
    }
}