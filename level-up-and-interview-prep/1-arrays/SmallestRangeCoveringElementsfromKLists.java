// Leetcode 632
// O(nlogk) time, O(k) space
class Solution {
    public class Box implements Comparable<Box> {
        int val;
        int row;
        int col;

        public Box(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Box object) {
            return this.val - object.val;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Box> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new Box(nums.get(i).get(0), i, 0));
            max = Math.max(max, nums.get(i).get(0));
        }

        int range = Integer.MAX_VALUE;
        int sp = 0, ep = Integer.MAX_VALUE;

        while (pq.size() == nums.size()) {
            Box bx = pq.remove();
            if (max - bx.val < range) {
                range = max - bx.val;
                sp = bx.val;
                ep = max;
            }

            if (bx.col + 1 <= nums.get(bx.row).size() - 1) {
                bx.col = bx.col + 1;
                bx.val = nums.get(bx.row).get(bx.col);
                max = Math.max(max, bx.val);
                pq.add(bx);
            }
        }

        int[] ans = new int[2];
        ans[0] = sp;
        ans[1] = ep;
        return ans;
    }
}