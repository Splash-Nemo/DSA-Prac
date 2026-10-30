package graphs;

class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int m= pre.length;

        boolean[] vis= new boolean[n];
        int[] deg= new int[n];

        List<Integer> list= new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();

        ArrayList<ArrayList<Integer>> grid= new ArrayList<>();

        for(int i=0; i<n; i++){
            grid.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            grid.get(pre[i][0]).add(pre[i][1]);
        }

        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid.get(i).size(); j++){
                deg[grid.get(i).get(j)]+=1;
            }
        }

        for(int i=0; i<n; i++){
            if(deg[i]==0) q.add(i);
        }

        BFS(q, vis, deg, grid, list);

        return !(list.size()<n);
    }

    public void BFS(Queue<Integer> q, boolean[] vis, int[] deg, ArrayList<ArrayList<Integer>> grid, List<Integer> list){

        while(!q.isEmpty()){
            int curr= q.poll();
            list.add(curr);

            vis[curr] = true;
            for(int k: grid.get(curr)){
                if(!vis[k]){
                    deg[k]-=1;

                    if(deg[k]==0){
                        q.add(k);
                        vis[k]= true;
                    }
                }
            }
        }
    }
}