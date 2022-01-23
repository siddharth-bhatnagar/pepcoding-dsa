//  Leetcode 13
// O(N) time, O(1) space

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (i + 1 < s.length() && map.get(ch) < map.get(s.charAt(i + 1))) {
                sum = sum + map.get(s.charAt(i + 1)) - map.get(ch);
                i++;
            } else {
                sum += map.get(ch);
            }
        }

        return sum;
    }
}