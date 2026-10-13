import java.util.*;
public class DFSGraphs {

    public static void DFS(int v, int[][] adj, int[] vis){
        vis[v]= 1;

        System.out.print(v+" ");

        for(int i=1; i<vis.length; i++){
            if(adj[v][i]==1 && vis[i]==0){
                DFS(i,adj,vis);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Enter number of vertices:- ");
        int v= sc.nextInt();
        int[] vis= new int[v+1];

        int[][] adj= new int[v+1][v+1];

        List<int[]> edges= new ArrayList<>();
        // int[][] edges= {{1,2},{1,4},{2,3},{4,5},{4,6},{5,6}};
        boolean bool= true;

        System.out.println("Enter edges");

        while(bool){

            int a= sc.nextInt();
            int b= sc.nextInt();

            int[] temp= {a,b};

            edges.add(temp);

            System.out.println("Continue? 1- Yes, 2- No:-");
            int k= sc.nextInt();

            if(k==1) bool=true;
            else bool=false;
        }

        for(int i=0; i<edges.size(); i++){
            int row= edges.get(i)[0];
            int col= edges.get(i)[1];

            adj[row][col]= 1;
            adj[col][row]= 1;
        }

        System.out.println();

        DFS(1,adj, vis);
    }   
}
 