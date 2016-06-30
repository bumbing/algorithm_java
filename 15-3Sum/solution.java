public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        //ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num.length<3)
            return result;
            
        Arrays.sort(num);//sort the array to save hashmap space
        
        //Traverse all numbers
        for(int i=0; i<num.length-2; ){
            if(num[i]>0)  
                break;
            int j = i+1;
            int k = num.length-1;
            while(j<k){
                if(num[i]+num[j]+num[k]==0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(num[i]);
                    tmp.add(num[j]);
                    tmp.add(num[k]);
                    result.add(tmp);
                    j=moveNext(j,num);
                }
                else if(num[i]+num[j]+num[k]<0) j=moveNext(j,num);
                else{
                    k = movePrevious(k,num);
                }
                
            }
            i=moveNext(i,num);
        }
        
        return result;
    }
    
    private int moveNext(int i, int[] num){
        while(i<num.length-1){
            ++i;
            if(num[i]!=num[i-1])
                break;
        }
        return i;
    }
    private int movePrevious(int i, int[] num){
        while(i>0){
            --i;
            if(num[i]!=num[i+1])
                break;
        }
        return i;
    }
}