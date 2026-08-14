class Solution {
    public boolean lemonadeChange(int[] bills) {
        boolean bool= true;
        int balance= 0;

        if(bills[0]>5 || bills.length==0) return false;

        int[] dn= new int[2];
        // 0 -> 5, 1 -> 10

        for(int i=0; i<bills.length; i++){
            if(bills[i]==5){
                balance+=5;
                dn[0]+=1;
            }else{
                if(bills[i]==10 && dn[0]>0){
                    balance-=5;
                    balance+=10;

                    dn[1]+=1;
                    dn[0]-=1;
                }else if(bills[i]==20 && balance >= 15){
                    balance-=15;
                    balance+=20;

                    if(dn[0]>0 && dn[1]>0){
                        dn[0]-=1;
                        dn[1]-=1;
                    }else if(dn[0]>=3){
                        dn[0]-=3;
                    }else return false;

                }else return false;
            }
        }

        return bool;
    }
}