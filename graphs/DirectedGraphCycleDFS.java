package graphs;

class Solution {
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj){
        // code here
        int n= adj.size();

        boolean[] vis= new boolean[n];
        boolean[] path= new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                if(DFS(i, vis, path, adj)) return true;
            }
        }

        return false;
    }

    public boolean DFS(int i, boolean[] vis, boolean[] path, ArrayList<ArrayList<Integer>> adj){
        vis[i]= true;
        path[i]= true;

        for(int j: adj.get(i)){
            if(!vis[j]){
                if(DFS(j, vis, path, adj)) return true;
            } else if(path[j]) return true;
        }

        path[i]= false;

        return false;
    }
}
