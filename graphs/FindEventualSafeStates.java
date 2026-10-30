class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<List<Integer>> adjList= new ArrayList<>();
        boolean[] vis= new boolean[graph.length];

        boolean[] path= new boolean[graph.length];
        List<Integer> ans= new ArrayList<>();

        boolean[] track= new boolean[graph.length];

        for(int i=0; i<graph.length; i++) adjList.add(new ArrayList<>());

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                adjList.get(i).add(graph[i][j]);
            }

            // if(adjList.get(i).size()==0) {
            //     vis[i]= true;
            //     ans.add(i);
            // }

            if(adjList.get(i).size()==0) {
                vis[i]= true;
                track[i]= true;
            }
        }

        for(int i=0; i<graph.length; i++){
            // if(!vis[i]) DFS(i, vis, path, adjList, ans);
            if(!vis[i]) DFS(i, vis, path, adjList, track);
        }

        for(int i=0; i<graph.length; i++){
            if(track[i]) ans.add(i);
        }

        return ans;
    }

    public boolean DFS(int i, boolean[] vis, boolean[] path, List<List<Integer>> adjList, List<Integer> ans){

        vis[i]= true;
        path[i]= true;

        for(int j: adjList.get(i)){
            if(!vis[j]){
                if(!DFS(j, vis, path, adjList, ans)) return false;
            }else if(path[j]){
                return false;
            }
        }

        ans.add(i);
        path[i]= false;

        return true;
    }

    public boolean DFS(int i, boolean[] vis, boolean[] path, List<List<Integer>> adjList, boolean[] track){

        vis[i]= true;
        path[i]= true;

        for(int j: adjList.get(i)){
            if(!vis[j]){
                if(!DFS(j, vis, path, adjList, track)) return false;
            }else if(path[j]){
                return false;
            }
        }

        track[i]= true;
        path[i]= false;

        return true;
    }
}