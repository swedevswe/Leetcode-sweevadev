class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int wordIndex = 1;
        int currentWordStart = 0;
        
        for(int i = 0; i <= sentence.length(); i++){
            if(i == sentence.length() || sentence.charAt(i) == ' '){
                if(sentence.startsWith(searchWord, currentWordStart)){
                    return wordIndex;
                }
                currentWordStart = i + 1;
                wordIndex++;
            }
        }
        return -1;
    }
}