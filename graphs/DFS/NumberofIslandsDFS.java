class Solution {
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        boolean[][] vis= new boolean[n][m];
        int ans= 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<grid[i].length; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    DFS(i, j, vis, grid);
                    ans+=1;
                }
            }
        }

        return ans;
    }

    public void DFS(int i, int j, boolean[][] vis, char[][] list){
        vis[i][j]= true;

        //up
        if(i>0 && !vis[i-1][j] && list[i-1][j]=='1')
            DFS(i-1, j, vis, list);

        //down
        if(i+1<list.length && !vis[i+1][j] && list[i+1][j]=='1')
            DFS(i+1, j, vis, list);

        //left
        if(j>0 && !vis[i][j-1] && list[i][j-1]=='1')
            DFS(i, j-1, vis, list);

        //right
        if(j+1<list[i].length && !vis[i][j+1] && list[i][j+1]=='1')
            DFS(i, j+1, vis, list);
    }
}