//4.Prefix tree 

class Node{
    Node[] child;
    boolean isEnd;
    Node(){
        child = new Node[26];
        isEnd = false;
    }
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            if(cur.child[c-'a'] == null){
                cur.child[c-'a'] = new Node();
            }
            cur = cur.child[c-'a'];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            if(cur.child[c-'a'] == null){
                return false;
            }
            cur = cur.child[c-'a'];
        }
        return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char c : prefix.toCharArray()){
            if(cur.child[c-'a'] == null){
                return false;
            }
            cur = cur.child[c-'a'];
        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

