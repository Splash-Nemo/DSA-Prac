package graphs;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 2) {
                    Pair temp = new Pair();
                    temp.i = i;
                    temp.j = j;

                    q.add(temp);

                    vis[i][j] = true;
                }
            }
        }

        ans += BFS(q, vis, grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1)
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

    public int BFS(Queue<Pair> q, boolean[][] vis, int grid[][]) {
        int count = 0;

        Queue<Pair> q2 = new LinkedList<>();

        Pair dummy = new Pair(-1, -1);
        q2.add(dummy);

        while (!q2.isEmpty()) {

            q2.clear();
            boolean bool = false;

            while (!q.isEmpty()) {

                Pair x = q.poll();

                int row = x.i;
                int col = x.j;

                vis[row][col] = true;

                //up
                if (row > 0 && vis[row - 1][col] == false && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    vis[row-1][col]= true;

                    Pair temp = new Pair();
                    temp.i = row - 1;
                    temp.j = col;

                    q2.add(temp);

                    bool = true;
                }

                //down
                if (row + 1 < grid.length && vis[row + 1][col] == false && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    vis[row+1][col]= true;

                    Pair temp = new Pair();
                    temp.i = row + 1;
                    temp.j = col;

                    q2.add(temp);

                    bool = true;
                }

                //left
                if (col > 0 && vis[row][col - 1] == false && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    vis[row][col-1]= true;

                    Pair temp = new Pair();
                    temp.i = row;
                    temp.j = col - 1;

                    q2.add(temp);

                    bool = true;
                }

                //right
                if (col + 1 < grid[0].length && vis[row][col + 1] == false && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    vis[row][col+1]= true;

                    Pair temp = new Pair();
                    temp.i = row;
                    temp.j = col + 1;

                    q2.add(temp);

                    bool = true;
                }

            }

            if(bool) count += 1;

            q.addAll(q2);
        }

        return count;
    }
}