public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(A[i][j]!=0){
                    ArrayList<Integer> tmp = map.getOrDefault(j, new ArrayList<Integer>());
                    tmp.add(i);
                    map.put(j, tmp);
                }
            }
        }
        for(int i=0; i<B.length; i++){
            for(int j=0; j<B[0].length; j++){
                if(B[i][j]!=0){
                    ArrayList<Integer> tmp = map.get(i);
                    if(tmp==null)   continue;
                    for(int k=0; k<tmp.size(); k++){
                        int num = tmp.get(k);
                        result[num][j] += A[num][i] * B[i][j];
                    }
                }
            }
        }
        return result;
    }
}