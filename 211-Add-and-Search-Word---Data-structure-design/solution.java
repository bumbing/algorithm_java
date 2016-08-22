public class WordDictionary {
    class TrieNode{
        TrieNode[] child = new TrieNode[26];
    }
    
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = this.root;
        for(int i=0; i<arr.length; i++){
            int index = arr[i] - 'a';
            if(cur.child[index]==null){
                cur.child[index] = new TrieNode();
            }
            cur = cur.child[index];
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        return searchHelper(arr, 0, this.root);
    }
    
    public boolean searchHelper(char[] arr, int head, TrieNode cur){
        if(head==arr.length)    return true;
        boolean result = false;
        if(arr[head]=='.'){
           for(TrieNode node: cur.child){
               if(node!=null){
                   result = result || searchHelper(arr, head+1, node);
               }
           } 
        }else{
            int index = arr[head]-'a';
            if(cur.child[index]==null)  return false;
            cur = cur.child[index];
            result = searchHelper(arr, head+1, cur);
        }
        return result;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");