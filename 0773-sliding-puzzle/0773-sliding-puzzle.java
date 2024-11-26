class Solution {
    public int slidingPuzzle(int[][] board) {
        //state
        //minmove
        //visited - to track already visited configurations.
        //solved state 
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for(int[] row : board){
            for(int num : row){
                sb.append(num);
            }
        }
        String start = sb.toString();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int moves = 0;
        int[][] directions = {
            //0  1  2
            //3  4  5
            {1,3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.poll();
                if(current.equals(target)){
                    return moves;
                }
                int zeroIndex = current.indexOf('0');
                for(int swapIndex : directions[zeroIndex]){
                    String nextState = swap(current, zeroIndex, swapIndex);
                    if(!visited.contains(nextState)){
                        queue.offer(nextState);
                        visited.add(nextState);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    private String swap(String state, int i, int j){
        char[] chars = state.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}