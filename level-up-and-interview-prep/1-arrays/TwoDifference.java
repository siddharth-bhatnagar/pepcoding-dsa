import java.util.HashMap;

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

// Using Hashmap in O(n) time but with O(n) space

// HashMap<Integer, Integer> map = new HashMap<>();
// for(int i=0;i<arr.length;i++) {
//     int num = arr[i];
//     int comp = n + num;

//     if(map.containsKey(comp)) {
//         return true;
//     }

//     map.put(num, i);
// }

// return false;