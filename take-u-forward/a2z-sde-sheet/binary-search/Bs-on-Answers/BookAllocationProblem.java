/*
 * Blog: https://takeuforward.org/data-structure/allocate-minimum-number-of-pages/ 
 */

import java.util.ArrayList;

public class BookAllocationProblem {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Range will be from Max(arr) to Sum(arr)
        // If it is Max(arr) all students will get atleast 1 book
        // If it is Sum(arr), we can give all books to one student.
        if (m > n) return -1;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (Integer pages: arr) {
            sum += pages;
            max = Math.max(pages, max);
        }
        
        int low = max;
        int high = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int studentsReqd = getStudents(arr, n, m , mid);
            if (studentsReqd <= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int getStudents(ArrayList<Integer> arr, int n, int m, int totalPages) {
        int countStudents = 1;
        int pages = 0;
        for (int i=0;i<n;i++) {
            if (arr.get(i) + pages <= totalPages) {
                pages += arr.get(i);
            } else {
                countStudents++;
                pages = arr.get(i);
            }
        }

        return countStudents;
    }
}
