# Trie

1. [Implement Trie (Prefix Tree)](#implement-trie-prefix-tree)
2. [Word Search II](#word-search-ii)

##  Implement Trie (Prefix Tree)
Q: Implement a trie with insert, search, and startsWith methods. You may assume that all inputs are consist of lowercase letters a-z.   
```
class TrieNode {
    char val;
    HashMap<Character, TrieNode> map;
    // Initialize your data structure here.
    public TrieNode() {
        map = new HashMap<>();
    }
    public TrieNode(char a) {
        this.val = a;
        map = new HashMap<>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode pnt = root;
        for(int i=0; i<word.length(); i++) {
            char a = word.charAt(i);
            if(!pnt.map.containsKey(a)) {
                TrieNode node = new TrieNode(a);
                pnt.map.put(a, node);
            }
            pnt = pnt.map.get(a);
        }
        pnt.map.put('#', new TrieNode());
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode pnt = root;
        for(int i=0; i<word.length(); i++) {
            char a = word.charAt(i);
            if(!pnt.map.containsKey(a)) {
                return false;
            }
            pnt = pnt.map.get(a);
        }
        return pnt.map.containsKey('#');
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode pnt = root;
        for(int i=0; i<prefix.length(); i++) {
            char a = prefix.charAt(i);
            if(!pnt.map.containsKey(a)) {
                return false;
            }
            pnt = pnt.map.get(a);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
```

## Word Search II
Q: Given a 2D board and a list of words from the dictionary, find all words in the board. Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word. You may assume that all inputs are consist of lowercase letters a-z.   
```
class TrieNode {
    char val;
    boolean isLeaf;
    HashMap<Character, TrieNode> map;
    TrieNode(char a) {
        val = a;
        map = new HashMap<>();
        isLeaf = false;
    }
}

TrieNode root = new TrieNode('#');
private void addWord(String str) {
    TrieNode pnt = root;
    for(int i=0; i<str.length(); i++) {
        char a = str.charAt(i);
        if(!pnt.map.containsKey(a)) {
            pnt.map.put(a, new TrieNode(a));
        }
        pnt = pnt.map.get(a);
    }
    pnt.isLeaf = true;
}

public List<String> findWords(char[][] board, String[] words) {
    List<String> list = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    for(String s:words) {
        addWord(s);
    }
    for(int i=0; i<board.length; i++) {
        for(int j=0; j<board[0].length; j++) {
            helper(list, board, root, i, j, sb);
        }
    }
    return list;
}

private void helper(List<String> list, char[][] board, TrieNode pnt, int r, int c, StringBuilder sb) {
    if(r>=board.length || r<0 || c>=board[0].length || c<0 || board[r][c]=='#' || !pnt.map.containsKey(board[r][c])) {
        return ;
    }
    sb.append(board[r][c]);
    char tmp = board[r][c];
    board[r][c] = '#';
    pnt = pnt.map.get(tmp);
    if(pnt.isLeaf) {
        list.add(sb.toString());
        pnt.isLeaf = false;
    }
    for(int i=-1; i<2; i+=2) {
        helper(list, board, pnt, r+i, c, sb);
        helper(list, board, pnt, r, c+i, sb);
    }
    board[r][c] = tmp;
    sb.deleteCharAt(sb.length()-1);
}
```



