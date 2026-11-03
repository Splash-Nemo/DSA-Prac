package graphs;

class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        // code here
        int n= edges.length;
        int[] dis= new int[V];

        Arrays.fill(dis, (int)Math.pow(10,8));
        dis[src]= 0;

        ArrayList<Integer> adj= new ArrayList<>();

        int loop= 0;

        for(int i=0; i<edges.length && loop<V; i++){
            int u= edges[i][0];
            int v= edges[i][1];
            int w= edges[i][2];

            if(dis[u] != (int)Math.pow(10,8) && dis[u] + w < dis[v]){
                if(loop==V-1){
                    ArrayList<Integer> ans= new ArrayList<>();
                    ans.add(-1);

                    return ans;
                }

                dis[v]= dis[u] + w;
            }

            if(i==edges.length-1){
                i=-1;
                loop+=1;
            }
        }

        for(int i: dis) adj.add(i);

        return adj;
    }
}

