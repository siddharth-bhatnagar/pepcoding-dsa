// O(nlogn) solution

class Solution {
    public boolean findPair(int arr[], int size, int n) {
        Arrays.sort(arr);
        int i=0, int j=1;
        while(j<size) {
            if(arr[j] - arr[i] == n){
                return true;
            }
            else if(arr[j] - arr[i] > n) {
                i++;
            }
            else {
                j++;
            }
        }
        
        return false;
    }
}
