// Leetcode 994

class Solution {
    public class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        LinkedList<Pair> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.addLast(new Pair(i, j));
                } else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        if (fresh == 0)
            return 0;

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        int level = -1;
        while (queue.size() > 0) {
            level++;
            int size = queue.size();

            while (size-- > 0) {
                Pair rem = queue.removeFirst();
                for (int i = 0; i < dirs.length; i++) {
                    int rowdash = rem.row + dirs[i][0];
                    int coldash = rem.col + dirs[i][1];

                    if (rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length
                            || grid[rowdash][coldash] != 1) {
                        continue;
                    }

                    queue.addLast(new Pair(rowdash, coldash));
                    fresh--;
                    grid[rowdash][coldash] = 2;
                }
            }
        }

        if (fresh == 0)
            return level;
        else
            return -1;
    }
}