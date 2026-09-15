class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ans= 0;

        if(g.length==0 || s.length==0) return 0;
        
        Arrays.sort(g);
        Arrays.sort(s);

        int gi= 0,  si= 0;

        while(si<s.length && s[si]<g[0]) si+=1;

        if(si==s.length) return 0;

        while(gi<g.length && si<s.length){
            if(g[gi]<=s[si]){
                ans+=1;
                gi+=1;
            }

            si+=1;
        }

        return ans;
    }
}