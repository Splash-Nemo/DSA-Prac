class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        boolean[] vis= new boolean[n];
        vis[source]= true;

        List<List<Integer>> list= new ArrayList<>();

        for(int i=0; i<n; i++) list.add(new ArrayList<>());

        for(int i=0; i<edges.length; i++){
            int a= edges[i][0], b= edges[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        BFS(source, vis, list);

        return vis[destination];
    }

    public void BFS(int j, boolean[] vis, List<List<Integer>> list){
        vis[j]= true;

        Queue<Integer> q= new LinkedList<>();
        q.add(j);

        while(!q.isEmpty()){
            int k= q.poll();

            for(int i: list.get(k)){
                if(!vis[i]){
                    vis[i]= true;
                    q.add(i);
                }
            }
        }
    }
}