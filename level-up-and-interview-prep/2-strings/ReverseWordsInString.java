class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        
        // converting to character array
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        // reverse whole array
        reverse(arr, 0, n-1);
        
        // reverse the words in-place leaving spaces intact
        reverseWords(arr, n);
        
        // clean trailing, leading, multiple spaces
        return cleanSpaces(arr, n);
    }
    
    private void reverse(char[] arr, int si, int ei) {
        while(si < ei) {
            char temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            
            si++;
            ei--;
        }
    }
    
    private void reverseWords(char[] arr, int n) {
        int i=0, j=0;
        while(i < n) {
            
            // skipping white space
            while(i < j || i < n && arr[i] == ' ') {
                i++;
            }
            
            // skipping non-space characters to reach end of word
            while(j < i || j < n && arr[j] != ' ') {
                j++;
            }
            
            reverse(arr, i, j-1);
        }
    }
    
    private String cleanSpaces(char[] a, int n) {
        int i=0,j=0;
        while (j < n) {
            while (j < n && a[j] == ' ')
                j++; // skip spaces
            while (j < n && a[j] != ' ')
                a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ')
                j++; // skip spaces
            if (j < n)
                a[i++] = ' '; // keep only one space
        }

        return new String(a).substring(0, i);
    }
}