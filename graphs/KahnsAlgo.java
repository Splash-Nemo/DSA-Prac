package graphs;
//Topological Sort BFS
class Solution {
    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n= adj.size();

        boolean[] vis= new boolean[n];
        int[] deg= new int[n];

        ArrayList<Integer> ans= new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<adj.get(i).size(); j++){
                deg[adj.get(i).get(j)]+=1;
            }
        }

        for(int i=0; i<n; i++){
            if(!vis[i] && deg[i]==0) BFS(i, ans, deg, vis, adj);
        }

        return ans;
    }

    public void BFS(int i, ArrayList<Integer> ans, int[] deg, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[i]= true;
        Queue<Integer> q= new LinkedList<>();

        q.add(i);

        while(!q.isEmpty()){
            int curr= q.poll();
            ans.add(curr);

            for(int j: adj.get(curr)){
                if(!vis[j]){
                    deg[j]-=1;

                    if(deg[j]<=0){
                        q.add(j);
                        vis[j]= true;
                    }
                }
            }
        }
    }
}
