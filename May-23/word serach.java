class Solution {
    public booealn search (char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, char[] words, int start) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (words[start] != board[i][j]) {
            return false;
        }
        if (start == word.length - 1) return true;
        //check visitsed
        char cur = board[i][j];
        board[i][j] = '0';
        boolean exist = exist(baord, i + 1, j, words, start+1)
                || exist(baord, i - 1, j, words, start+1)
                || exist(baord, i, j - 1, words, start+1)
                || exist(baord, i, j + 1, words, start+1);
        board[i][j] = cur;
        return exist;
    }
}