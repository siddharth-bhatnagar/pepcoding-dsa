/**
 * Definition of Interval: public classs Interval { int start, end; Interval(int
 * start, int end) { this.start = start; this.end = end; } }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0)
            return 0;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int cc = 0, oc = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (start[i] <= end[j]) {
                cc++;
                oc = Math.max(oc, cc);
                i++;
            } else {
                cc--;
                j++;
            }
        }

        return oc;
    }
}