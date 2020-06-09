/*
1. greedy: as many as possible
2. Not the last line
spaces between words should be distributed as even as possible and as left as possible
The last line /only one word
1. decide how many words can be put in one line
2. modify the space between words

wordIndex -- keep index in words
totolChars -- the total chars used in one line (words + spaces)
gaps -- the number of gaps used wordsIndex and last
sb stringbuilder for one line
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < n) {
                if (totalChars + words[last].length() + 1 > maxWidth) break;
                totalChars += (words[last].length() + 1);
                last++;
            }

            int gaps = last - index - 1;
            StringBuilder sb = new StringBuilder();
            //if the last line or only one word not need to justify space
            if (last == n || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }

                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }

            } else {
                int spaces = (maxWidth - totalChars) / gaps;
                int rest = (maxWidth - totalChars) % gaps;

                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                    // there is rest or not
                    for (int j = 0; j < spaces + (i - index < rest ? 1 : 0); j++) {
                        sb.append(' ');
                    }
                }
                sb.append(words[last-1]);
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
}