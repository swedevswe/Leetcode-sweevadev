class Solution {
    public String reverseParentheses(String s) {
        
        //reverse the substrings starting from the innermost pair
        //use Stack! keep track of character and nested parentheses
        
        Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()){
                if(c == ')'){
                    List<Character> temp = new ArrayList<>();
                    while(stack.peek() != '('){
                        temp.add(stack.pop());
                    }
                    stack.pop(); // removed the '(' from the stack
                    for(char ch : temp){
                        stack.push(ch);
                    }
                }else{
                    stack.push(c);
                }
            }
            StringBuilder result = new StringBuilder();
            for(char c : stack){
                result.append(c);
            }
            return result.toString();
        }
    }
