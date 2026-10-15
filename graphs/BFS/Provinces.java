class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int ans= 0;

        boolean[] vis= new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                ans+=1;
                BFS(i, vis, isConnected);
            }
        }

        return ans;
    }

    public void BFS(int i, boolean[] vis, int[][] list){
        vis[i]= true;
        Queue<Integer> q= new LinkedList<>();

        q.add(i);

        while(!q.isEmpty()){
            int k= q.poll();

            for(int j=0; j<list[k].length; j++){
                int curr= list[k][j];
                if(!vis[j] && curr==1){
                    vis[j]= true;
                    q.add(j);
                }
            }
        }
    }
}