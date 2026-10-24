class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean[] vis= new boolean[n];
        vis[0]= true;

        // if(rooms.get(0).isEmpty()) return false;

        for(int i=0; i<rooms.get(0).size(); i++){
            DFS(rooms.get(0).get(i), vis, rooms);
        }

        for(boolean bool: vis) if(!bool) return false;

        return true;
    }

    public void DFS(int x, boolean[] vis, List<List<Integer>> rooms){
        vis[x]= true;

        for(int i=0; i<rooms.get(x).size(); i++){
            int curr= rooms.get(x).get(i);
            if(!vis[curr]) DFS(curr, vis, rooms);
        }
    }
}