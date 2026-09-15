package greedy;
class Solution {
    public int candy(int[] ratings) {
        int n= ratings.length;
        int[] candy= new int[n];

        if(n==1) return 1;

        if(n==0) return 0;

        Arrays.fill(candy, 1);

        if(ratings[0]>ratings[1]) candy[0]+=1;

        for(int i=1; i<n; i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]= candy[i-1]+1;
            }
        }

        for(int i=n-1; i>=0; i--){
            if(i<n-1 && ratings[i]>ratings[i+1]){
                if(candy[i]<=candy[i+1]) candy[i]= candy[i+1]+1;
            }
        }

        int sum= 0;

        for(int i:candy){ 
            System.out.print(i+" ");
            sum+=i;
        }

        return sum;
    }
}