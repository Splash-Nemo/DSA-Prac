package graphs;
class Solution {
    public void solve(char[][] board) {
        int m= board.length;
        int n= board[0].length;

        boolean[][] vis= new boolean[m][n];
        Queue<Pair> q= new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='X'){
                    vis[i][j]= true;
                }
            }
        }

        for(int i=0; i<m; i++){
            if(board[i][0]!='X'){
                vis[i][0]= true;
                Pair p = new Pair(i,0);
                q.add(p);
            }

            if(board[i][n-1]!='X'){
                vis[i][n-1]= true;
                Pair p = new Pair(i,n-1);
                q.add(p);
            }
        }

        for(int j=0; j<n; j++){
            if(board[0][j]!='X'){
                vis[0][j]= true;
                Pair p = new Pair(0,j);
                q.add(p);
            }

            if(board[m-1][j]!='X'){
                vis[m-1][j]= true;
                Pair p = new Pair(m-1,j);
                q.add(p);
            }
        }

        BFS(q, board, vis);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j]){
                    board[i][j]= 'X';
                }
            }
        }
    }

    class Pair{
        int i;
        int j;

        Pair(int i, int j){
            this.i= i;
            this.j= j;
        }
    }

    public void BFS(Queue<Pair> q, char[][] board, boolean[][] vis){
        while(!q.isEmpty()){
            int size= q.size();

            for(int i=0; i<size; i++){
                Pair p= q.poll();
                int row= p.i;
                int col= p.j;

                //up
                if(row>0 && !vis[row-1][col] && board[row-1][col]!='X'){
                    Pair temp= new Pair(row-1, col);
                    vis[row-1][col]= true;
                    q.add(temp);
                }

                //down
                if(row<board.length-1 && vis[row+1][col]==false && board[row+1][col]!='X'){
                    Pair temp= new Pair(row+1, col);
                    vis[row+1][col]= true;
                    q.add(temp);

                }

                //right
                if(col<board[0].length-1 && vis[row][col+1]==false && board[row][col+1]!='X'){
                    Pair temp= new Pair(row, col+1);
                    q.add(temp);
                    vis[row][col+1]= true;
                }

                //left
                if(col>0 && vis[row][col-1]==false && board[row][col-1]!='X'){
                    Pair temp= new Pair(row, col-1);
                    q.add(temp);
                    vis[row][col-1]= true;
                }
            }
        }
    }
}