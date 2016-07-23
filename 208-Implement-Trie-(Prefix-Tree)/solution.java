class TrieNode {
    // Initialize your data structure here.
    TrieNode[] child;
    int count = 0;
    boolean end = false;
    public TrieNode() {
        child = new TrieNode[26];
        Arrays.fill(child, null);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode root = this.root;
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(root.child[index] == null){
                root.child[index] = new TrieNode();
            }
            root = root.child[index];
            root.count++;
        }
        root.end = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode root = this.root;
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(root.child[index] == null)   return false;
            root = root.child[index];
        }
        return root.end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode root = this.root;
        for(int i=0; i<prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(root.child[index] == null)   return false;
            root = root.child[index];
        }
        return root.count>0;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");