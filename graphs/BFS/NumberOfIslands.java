class Solution {
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        boolean[][] bool= new boolean[n][m];
        int ans=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!bool[i][j] && grid[i][j]=='1'){
                    BFS(i,j, bool, grid);
                    ans+=1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(bool[i][j]+" ");
            }

            System.out.println();
        }

        return ans;
    }

    class Pair{
        int i;
        int j;

        Pair(int i, int j){
            this.i= i;
            this.j= j;
        }
    }

    public void BFS(int i, int j, boolean[][] vis, char[][] grid){
        int n= grid.length;
        int m= grid[0].length;

        vis[i][j]= true;

        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(i,j));

        while(!q.isEmpty()){
            Pair k= q.poll();
            i= k.i;
            j= k.j;
            
            if(vis[k.i][k.j]){

            if(i>0){
                if(!vis[i-1][j] && grid[i-1][j]=='1'){
                    q.add(new Pair(i-1, j));
                    vis[i-1][j]= true;
                }
            }

            if(j>0){
                if(!vis[i][j-1] && grid[i][j-1]=='1'){
                    q.add(new Pair(i,j-1));
                    vis[i][j-1]= true;
                }
            }

            if(j+1<m){
                if(!vis[i][j+1] && grid[i][j+1]=='1'){
                    q.add(new Pair(i,j+1));
                    vis[i][j+1]= true;
                }
            }

            if(i+1<n){
                if(!vis[i+1][j] && grid[i+1][j]=='1'){
                    q.add(new Pair(i+1, j));
                    vis[i+1][j]= true;
                }
            }
            }
        }
    }
}