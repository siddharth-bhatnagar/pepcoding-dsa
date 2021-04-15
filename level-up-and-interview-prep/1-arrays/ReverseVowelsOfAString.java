// Leetcode 345
class Solution {
    public static String reverseVowels(String s) {

        char[] c = s.toCharArray();
        HashSet<Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int i = 0, j = c.length - 1;

        while (i < j) {
            if (vowels.contains(c[i]) && vowels.contains(c[j])) {
                swap(c, i, j);
                i++;
                j--;
            } else if (!vowels.contains(c[i]) && !vowels.contains(c[j])) {
                i++;
                j--;
            } else if (vowels.contains(c[i]) && !vowels.contains(c[j])) {
                j--;
            } else {
                i++;
            }
        }

        return new String(c);
    }

    public static void swap(char[] arr, int i, int j) {
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
}