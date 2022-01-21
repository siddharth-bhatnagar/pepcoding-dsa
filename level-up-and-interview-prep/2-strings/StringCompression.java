class Solution {
    public int compress(char[] chars) {
        int length = 0, index = 0, n = chars.length;
        
        while(index < n) {
            char curr = chars[index];
            int count = 0;
            while(index < n && chars[index] == curr) {
                count++;
                index++;
            }

            chars[length] = curr;
            length++;
            if(count > 1) {
                for(char c: Integer.toString(count).toCharArray()) {
                    chars[length] = c;
                    length++;
                }
            }
        }
        return length;
    }
}