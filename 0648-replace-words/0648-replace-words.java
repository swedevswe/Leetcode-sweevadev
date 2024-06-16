class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String word : dictionary){
            trie.insert(word);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(String word : words){
            String root = trie.findRoot(word);
            sb.append(root == null ? word : root).append(" ");
        }
        return sb.toString().trim();
    }
    class Trie{
        Trie[] children = new Trie[26];
        boolean isEndOfWord = false;
        
        void insert(String word){
            Trie node = this;
            for(char c : word.toCharArray()){
                int index = c - 'a';
                if(node.children[index] == null){
                    node.children[index]=new Trie();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }
        String findRoot(String word){
            Trie node = this;
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()){
                int index = c - 'a';
                if(node.children[index] == null){
                    return null;
                }
                sb.append(c);
                node = node.children[index];
                if(node.isEndOfWord){
                    return sb.toString();
                }
            }
            return null;
        }
    }
}