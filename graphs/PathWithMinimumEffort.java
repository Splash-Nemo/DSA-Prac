package graphs;

class Solution {
    public int minimumEffortPath(int[][] h) {
        int row= h.length, col= h[0].length;
        int[][] efforts= new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                efforts[i][j]= Integer.MAX_VALUE;
            }
        }

        efforts[0][0]= 0;

        Nodes start= new Nodes(0,0,0);

        PriorityQueue<Nodes> pq= new PriorityQueue<>(
                (a,b) -> Integer.compare(a.dis, b.dis)
        );

        pq.add(new Nodes(0,0,0));

        while(!pq.isEmpty()){
            Nodes f= pq.poll();
            int r= f.row, c= f.col, e= f.dis;

            if(e>efforts[r][c]) continue;

            //up
            if(r>0){
                int absD= Math.abs(h[r][c]-h[r-1][c]);
                int neweff= Math.max(e,absD);

                if(neweff < efforts[r-1][c]){
                    efforts[r-1][c]= neweff;

                    Nodes up= new Nodes(r-1,c, efforts[r-1][c]);
                    pq.add(up);
                }
            }

            //down
            if(r<row-1){
                int absD= Math.abs(h[r][c]-h[r+1][c]);
                int neweff= Math.max(e,absD);

                if(neweff<efforts[r+1][c]){
                    efforts[r+1][c]= neweff;
                    Nodes down= new Nodes(r+1,c, Math.max(e, absD));
                    pq.add(down);
                }
            }

            //left
            if(c>0){
                int absD= Math.abs(h[r][c]-h[r][c-1]);
                int neweff= Math.max(absD, e);

                if(neweff<efforts[r][c-1]){
                    efforts[r][c-1]= neweff;
                    Nodes left= new Nodes(r,c-1, Math.max(e, absD));
                    pq.add(left);
                }

            }

            //right
            if(c<col-1){
                int absD= Math.abs(h[r][c]-h[r][c+1]);
                int neweff= Math.max(e, absD);

                if(neweff<efforts[r][c+1]){
                    efforts[r][c+1]= neweff;
                    Nodes right= new Nodes(r,c+1, Math.max(e, absD));
                    pq.add(right);
                }

            }
        }

        return efforts[row-1][col-1];
    }

    class Nodes{
        int row, col, dis;
        Nodes(int row, int col, int dis){
            this.row= row;
            this.col= col;
            this.dis= dis;
        }
    }
}