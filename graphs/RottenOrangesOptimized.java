package graphs;
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    Pair temp = new Pair();
                    temp.i = i;
                    temp.j = j;

                    q.add(temp);
                }
            }
        }

        ans += BFS(q, grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return ans;
    }

    class Pair {
        int i;
        int j;

        Pair() {
        }

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int BFS(Queue<Pair> q, int grid[][]) {
        int count = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            boolean bool = false;

            for (int i = 0; i < size; i++) {

                Pair x = q.poll();

                int row = x.i;
                int col = x.j;

                //up
                if (row > 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;

                    Pair temp = new Pair();
                    temp.i = row - 1;
                    temp.j = col;

                    q.add(temp);
                    bool = true;
                }

                //down
                if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;

                    Pair temp = new Pair();
                    temp.i = row + 1;
                    temp.j = col;

                    q.add(temp);
                    bool = true;
                }

                //left
                if (col > 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;

                    Pair temp = new Pair();
                    temp.i = row;
                    temp.j = col - 1;

                    q.add(temp);

                    bool = true;
                }

                //right
                if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;

                    Pair temp = new Pair();
                    temp.i = row;
                    temp.j = col + 1;

                    q.add(temp);

                    bool = true;
                }

            }

            if (bool)
                count += 1;
        }

        return count;
    }
}