package graphs;
import java.util.*;

public class CycleDetectionBFS {

    public void DetectCycle(List<List<Integer>> list){
        int n= list.size();
        boolean[] vis= new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                BFS(i, vis, list);
            }
        }
    }

    class Pair{
        int node;
        int parent;
    }

    public void BFS(int i, boolean[] vis, List<List<Integer>> list){
        vis[i]= true;

        Queue<Pair> q= new LinkedList<>();
        Pair p= new Pair();

        p.node= i;
        p.parent= -1;

        q.add(p);

        while(!q.isEmpty()){
            Pair k= q.poll();
            int node= k.node;
            int parent= k.parent;

            for(int x: list.get(node)){
                if(vis[x]){
                    if(x!=parent) {
                        System.out.println("Cycle detected at: " + x);
                        return;
                    }
                }else {

                    vis[x] = true;
                    Pair temp = new Pair();
                    temp.node = x;
                    temp.parent = node;

                    q.add(temp);
                }
            }
        }
    }
}
