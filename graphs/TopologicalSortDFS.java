package graphs;

class Solution {
    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i<adj.size(); i++) {
            if(!vis[i]) DFS(i, ans, vis, adj);
        }

        Collections.reverse(ans);

        return ans;
    }

    public void DFS(int i, ArrayList<Integer> ans, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[i]= true;

        for(int j:adj.get(i)){
            if(!vis[j]) DFS(j, ans, vis, adj);
        }

        ans.add(i);
    }
}
