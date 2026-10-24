class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        boolean[] vis= new boolean[n];

        int ans=0;

        for(int i=0; i<n; i++){
            if(!vis[i]){
                DFS(i, vis, isConnected);
                ans+=1;
            }
        }

        return ans;
    }

    public void DFS(int x, boolean[] vis, int[][] list){
        vis[x]= true;

        for(int i=0; i<list.length; i++){
            int curr= list[x][i];

            if(vis[i]) continue;
            else if(curr==1) DFS(i, vis, list);
        }
    }
}