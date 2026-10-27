package graphs;

class Solution {
    public int numEnclaves(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        int ans= 0;
        boolean[][] vis= new boolean[m][n];

        for(int i=0; i<m ;i++){
            if(i==0 || i==m-1){
                for(int j=0; j<n; j++){
                    if(grid[i][j]==1){
                        DFS(i, j, grid, vis);
                    }
                }
            }else{
                if(grid[i][0]==1) DFS(i, 0, grid, vis);
                if(grid[i][n-1]==1) DFS(i, n-1, grid, vis);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && !vis[i][j]) ans+=1;
            }
        }

        return ans;
    }

    public void DFS(int i, int j, int[][] grid, boolean[][] vis){
        vis[i][j]= true;

        //up
        if(i>0 && vis[i-1][j]==false && grid[i-1][j]==1)
            DFS(i-1,j,grid, vis);

        //down
        if(i+1<grid.length && vis[i+1][j]==false && grid[i+1][j]==1)
            DFS(i+1,j,grid, vis);

        //left
        if(j>0 && vis[i][j-1]==false && grid[i][j-1]==1)
            DFS(i,j-1,grid, vis);

        //right
        if(j+1<grid[0].length && vis[i][j+1]==false && grid[i][j+1]==1)
            DFS(i,j+1,grid, vis);
    }
}