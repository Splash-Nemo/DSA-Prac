package graphs;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;

        boolean[] vis= new boolean[n];

        boolean bool = false;

        int[] color= new int[n];

        for(int i=0; i<n; i++) color[i]= -1;

        for(int i=0; i<n; i++){
            if(!vis[i]){
                bool= BFS(i, vis, color, graph);
            }

            if(!bool) return false;
        }

        return true;
    }

    public boolean BFS(int i, boolean[] vis, int[] color, int[][] graph){
        vis[i]= true;
        color[i]= 0;

        Queue<Integer> q= new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()){
            int curr= q.poll();
            int k= color[curr]; //0-red, 1-blue, -1-unvisited

            for(int j=0; j<graph[curr].length; j++){
                int x= graph[curr][j];

                if(vis[x]){
                    if(color[x]==k) return false;
                }

                if(!vis[x]){
                    if(k==0){
                        color[x]= 1;
                    }else{
                        color[x]= 0;
                    }

                    vis[x]= true;
                    q.add(x);
                }

            }
        }

        return true;
    }
}