public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i < s.length() && j >= 0; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
}
/*
After coding the solution we had some more discussion on space and time optimization.
He also asked if the string cannot fit in the memory of 1 system, how will I modify my approach?

I think if we can store some portion (maybe length x) of the string from the beginning and length x reading from the end
(assuming we can fit 2x characters in memory) and start comparing. Once we git the end of the section,
we load the next x characters from disk and so on. That's what im thinking
 */