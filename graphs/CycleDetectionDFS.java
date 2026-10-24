package graphs;
import java.util.*;
public class CycleDetectionDFS {
    public void DetectCycleUsingDFS(List<List<Integer>> list){
        int n= list.size();
        boolean[] vis= new boolean[n];

        for(int i=0; i<list.size(); i++){
            if(!vis[i]){
                if(DFS(i, -1, vis, list)) break;
            }
        }
    }

    public boolean DFS(int node, int parent, boolean[] vis, List<List<Integer>> list){
        vis[node]= true;

        for(int i:list.get(node)){
            if(vis[i]){
                if(i!=parent){
                    System.out.println("Cycle Detected at: "+ i);
                    return true;
                }
            }else{
                if(DFS(i, node, vis, list)) return true;
            }
        }

        return false;
    }
}
