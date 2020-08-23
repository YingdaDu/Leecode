class Trie {
    class TrieNode {
        public char val;
        public boolean isWord;
        public HashMap<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {}
        public TrieNode(char c) {
            TrieNode node = new TrieNode();
            this.val = c;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChild = root.children;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            char wc = words[i];
            if (curChild.containsKey(wc)) {
                cur = curChild.get(wc);
            } else {
                TrieNode n = new TrieNode(wc);
                curChild.put(wc, n);
                cur = n;
            }
            curChild = cur.children;
            if (i == words.length - 1) {
                cur.isWord = true;
            }
        }
    }
}

class Trie {
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

    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

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
}