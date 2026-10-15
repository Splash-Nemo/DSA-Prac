class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();

        boolean[] vis= new boolean[n];
        vis[0]= true;

        // for(int i=0; i<n; i++){
        //     if(vis[i]){
        //         BFS(i, vis, rooms);
        //     }
        // }

        BFS(0, vis, rooms);

        for(boolean bool: vis)
            if(!bool) return false;

        return true;
    }

    public void BFS(int i, boolean[] vis, List<List<Integer>> list){
        Queue<Integer> q= new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()){
            int k= q.poll();

            for(int j: list.get(k)){
                if(!vis[j]){
                    vis[j]= true;
                    q.add(j);
                }
            }
        }
    }
}