package graphs;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;

        boolean[][] vis= new boolean[m][n];

        Queue<Pair> q= new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0) {
                    vis[i][j]= true;
                    q.add(new Pair(i,j));
                }
            }
        }

        BFS(q,mat,vis);

        return mat;
    }

    class Pair{
        int i;
        int j;

        Pair(){}

        Pair(int i, int j){
            this.i= i;
            this.j= j;
        }
    }

    public void BFS(Queue<Pair> q, int[][] mat, boolean[][] vis){

        while(!q.isEmpty()){
            int size= q.size();

            for(int i=0; i<size; i++){

                Pair pair= q.poll();

                int row= pair.i;
                int col= pair.j;

                int value=0;

                //up
                if(row>0 && !vis[row-1][col] && mat[row-1][col]!=0){
                    mat[row-1][col]= 1+mat[row][col];
                    vis[row-1][col]= true;

                    Pair temp= new Pair(row-1, col);
                    q.add(temp);
                }

                //down
                if(row+1<mat.length && !vis[row+1][col] && mat[row+1][col]!=0){
                    mat[row+1][col]= mat[row][col]+1;
                    vis[row+1][col]= true;

                    Pair temp= new Pair(row+1, col);
                    q.add(temp);
                }

                //left
                if(col>0 && vis[row][col-1]==false && mat[row][col-1]!=0){
                    mat[row][col-1]= 1+mat[row][col];
                    vis[row][col-1]= true;

                    Pair temp= new Pair(row, col-1);
                    q.add(temp);
                }

                //right
                if(col+1<mat[0].length && vis[row][col+1]==false && mat[row][col+1]!=0){
                    mat[row][col+1]= 1+ mat[row][col];
                    vis[row][col+1]= true;

                    Pair temp= new Pair(row, col+1);
                    q.add(temp);
                }
            }
        }
    }
}
