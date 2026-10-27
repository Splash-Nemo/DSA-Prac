package graphs;
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m= image.length;
        int n= image[0].length;

        boolean[][] vis= new boolean[m][n];
        int x= image[sr][sc];

        DFS(sr,sc, x, color, image, vis);

        return image;
    }

    public void DFS(int sr, int sc, int x, int color, int[][] list, boolean[][] vis){
        vis[sr][sc]= true;
        list[sr][sc]= color;

        //up
        if(sr>0 && vis[sr-1][sc]==false && list[sr-1][sc]==x)
            DFS(sr-1, sc, x, color, list, vis);

        //down
        if(sr+1<list.length && vis[sr+1][sc]==false && list[sr+1][sc]==x)
            DFS(sr+1, sc, x, color, list, vis);

        //left
        if(sc>0 && vis[sr][sc-1]==false && list[sr][sc-1]==x)
            DFS(sr, sc-1, x, color, list, vis);

        //right
        if(sc+1<list[0].length && vis[sr][sc+1]==false && list[sr][sc+1]==x)
            DFS(sr, sc+1, x, color, list, vis);
    }
}
