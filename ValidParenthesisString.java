class Solution {
    public boolean checkValidString(String s) {
        if(s.charAt(0)==')' || s.length()==0) return false;

        int lmin= 0, lmax= 0;

        for(int i=0; i<s.length(); i++){

            char ch= s.charAt(i);

            if(ch=='('){
                lmin+=1;
                lmax+=1;
            }else if(ch=='*'){
                lmin-=1;
                lmax+=1;
            }else{
                lmin-=1;
                lmax-=1;
            }

            if(lmax<0) return false;
            else if(lmin<0) lmin= 0;
        }


        return lmin==0;
    }
}