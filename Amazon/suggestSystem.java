class Solution {
    class TrieNode {
        char c;
        List<String> words = new ArrayList<>();
        TrieNode[] children = new TrieNode[26];
        public TrieNode(char c) {
            this.c  = c;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        TrieNode root = new TrieNode(' ');
        // build Trie
        for (String s : products) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur.children[c - 'a'].words.add(s);
                cur = cur.children[c - 'a'];
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            res.add(new ArrayList<String>());
        }

        TrieNode cur = root;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            cur = cur.children[c -'a'];
            if (cur == null) break;
            List<String> list = cur.words;
            Collections.sort(list);
            for (int k = 0; k < Math.min(3, list.size()); k++) {
                res.get(i).add(list.get(k));
            }
        }
        return res;
    }
}