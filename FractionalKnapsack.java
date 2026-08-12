import java.util.*;

class FractionalKnapsack {
    double[] weight;
    double[] value;
    int n;
    double capacity;

    double[][] items;
    
    public FractionalKnapsack(double[] weight, double[] value, int n, double capacity) {
        this.weight = weight;
        this.value = value;
        this.n = n;
        this.capacity = capacity;
        
        createItems(this.weight, this.value);
    }
    
    void createItems(double[] weight, double[] value){
        items= new double[n][2];
        for(int i=0; i<n; i++){
            items[i][0]= weight[i];
            items[i][1]= value[i];
        }
    }

    public double getMaxValue(){
        double maxValue= 0;
        Arrays.sort(items, (a,b)-> Double.compare(b[1]/b[0], a[1]/a[0]));
        
        for(int i=0; capacity>0 && i<n; i++){
            if(capacity>=items[i][0]){
                maxValue+= items[i][1];
                capacity-=items[i][0];
            }else{
                maxValue+= items[i][1]*(capacity/items[i][0]);
                capacity= 0;
            }
        }

        return maxValue;
    }
}
