class Solution {
    public String makeGood(String s){
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(c - stack.peek())==32){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        
        StringBuilder goodString = new StringBuilder();
        for(char c : stack){
            goodString.append(c);
        }
        return goodString.toString();
    }
}