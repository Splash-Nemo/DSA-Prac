package graphs;

class Solution {
    public String findOrder(String[] words) {
        // code here
        int n= words.length;

        List<List<Integer>> adj= new ArrayList<>();
        int[] deg= new int[26];

        boolean[] exists= new boolean[26];
        boolean[][] edges= new boolean[26][26];

        for(int i=0; i<26; i++){
            deg[i]= -1;
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<words[i].length(); j++){
                char ch= words[i].charAt(j);
                exists[ch-'a']= true;
                deg[ch-'a']= 0;
            }
        }

        for(int i=0; i<n-1; i++){

            String a= words[i];
            String b= words[i+1];

            int m= Math.min(a.length(), b.length());

            boolean found= false;

            for(int j=0; j<m; j++){
                char c1= a.charAt(j), c2= b.charAt(j);

                if(c1!=c2){
                    int i1= (int)(c1-'a');
                    int i2= (int)(c2-'a');

                    if(!edges[i1][i2])
                        adj.get(i1).add(i2);

                    found= true;

                    break;
                }
            }

            if(!found && b.length()<a.length()) return "";
        }

        int x=0;

        for(int i=0; i<26; i++){
            if(exists[i]){
                for(int j: adj.get(i)){
                    deg[j]+=1;
                }
                x+=1;
            }
        }

        Queue<Integer> q= new LinkedList<>();

        for(int i=0; i<26; i++){
            if(exists[i] && deg[i]==0){
                q.add(i);
            }
        }

        StringBuilder ans= new StringBuilder("");

        if(!BFS(q,deg,adj,ans,x)) return "";

        return ans.toString();
    }

    public boolean BFS(Queue<Integer> q, int[] deg, List<List<Integer>> adj, StringBuilder ans, int x){
        while(!q.isEmpty()){
            int curr= q.poll();
            ans.append((char)(curr+'a'));

            for(int k:adj.get(curr)){
                deg[k]-=1;

                if(deg[k]==0) q.add(k);
            }
        }

        // System.out.println(x);
        // System.out.println(ans);

        return ans.length() == x;
    }
}
