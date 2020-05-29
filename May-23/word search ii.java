class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    public TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}


class Trie {

    /** Initialize your data structure here. */
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.val =  ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}

public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    for (String word : words) {
        trie.insert(word);
    }
    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            dfs(board, i, j, "", trie, set);
        }
    }
    return new ArrayList<String>(set);
}

public void dfs(char[][] board, int i, int j, String str, Trie trie, HashSet<String> set) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
        return;
    }
    str += board[i][j];
    if (!trie.startsWith(str)) return;

    if (trie.search(str)) {
        set.add(str);
    }
    char tmp = board[i][j];
    board[i][j] = '#';
    dfs(board, i+1, j, str, trie, set);
    dfs(board, i-1, j, str, trie, set);
    dfs(board, i, j+1, str, trie, set);
    dfs(board, i, j-1, str, trie, set);
    board[i][j] = tmp;
}
