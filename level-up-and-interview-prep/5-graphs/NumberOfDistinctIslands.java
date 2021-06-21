// Leetcode prem || Lintcode 860

public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    StringBuilder sb;

    public int numberofDistinctIslands(int[][] grid) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sb = new StringBuilder();
                    sb.append("X");
                    dfs(grid, i, j);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;

        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            sb.append("T");
            dfs(grid, i - 1, j);
        }

        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            sb.append("L");
            dfs(grid, i, j - 1);
        }

        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            sb.append("D");
            dfs(grid, i + 1, j);
        }

        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            sb.append("R");
            dfs(grid, i, j + 1);
        }

        sb.append("Z");
    }
}

// StringBuilder is using in order to reduce complexity of appending characters to a string
// set is used to handle the duplicate islands or islands with same structure
// String is used to store the structure of the island or rather the path taken to traverse the island
// If the island were similar, then from the starting point of the island, identical calls would be made to traverse it.
// We are tracking that call pattern in a string and finally pushing patterns into a set which would handle the duplicacies
// Returning the size of the set would give the exact count of distinct islands