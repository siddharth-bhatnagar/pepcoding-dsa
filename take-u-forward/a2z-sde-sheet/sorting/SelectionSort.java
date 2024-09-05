/*
 * Blog: https://takeuforward.org/sorting/selection-sort-algorithm/
 * O(N*N)
 */
public class SelectionSort {
    void selectionSort(int arr[], int n) {
	    for (int i = 0; i <= n - 2; i++) {
	        int min = Integer.MAX_VALUE;
	        int minIdx = -1;
	        for (int j = i; j <= n - 1; j++) {
	            if (arr[j] < min) {
	                min = arr[j];
	                minIdx = j;
	            }
	        }
	        
	        int temp = arr[i];
	        arr[i] = min;
	        arr[minIdx] = temp;
	    }
    }
}
