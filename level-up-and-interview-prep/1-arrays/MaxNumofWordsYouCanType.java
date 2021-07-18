// Leetcode weekly 250
// Leetcode 1935

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        int count = 0;
        int words = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                words++;
        }
        words++;
        for (int i = 0; i < text.length(); i++) {
            char c1 = text.charAt(i);
            for (int j = 0; j < brokenLetters.length(); j++) {
                char c2 = brokenLetters.charAt(j);
                if (c1 == c2) {
                    count++;
                    while (i < text.length() - 1 && text.charAt(i) != ' ') {
                        i++;
                    }

                }
            }
        }
        int ans = words - count;
        return ans;
    }
}
