public class Trie {
    private Trie[] next;
    private boolean isEnd;
    public Trie() {
        next=new Trie[26];
        isEnd=false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node=this;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(node.next[index]==null){
                Trie temp=new Trie();
                node.next[index]=temp;
            }
            node=node.next[index];
        }
        node.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node=this;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(node.next[index]!=null){
                node=node.next[index];
            }else{
                return false;
            }
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node=this;
        for(int i=0;i<prefix.length();i++){
            int index=prefix.charAt(i)-'a';
            if(node.next[index]!=null){
                node=node.next[index];
            }else{
                return false;
            }
        }
        return true;
    }
}
