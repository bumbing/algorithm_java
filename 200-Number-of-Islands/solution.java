public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0)  return 0;
        if(grid[0].length==0)   return 0;
        int result = 0;
        //bfs
        boolean[][] traversed = new boolean[grid.length][grid[0].length];
        for(boolean[] group: traversed)     Arrays.fill(group, false);
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!traversed[i][j] && grid[i][j]=='1'){
                    result++;
                    ArrayList<Integer> nodes = new ArrayList<Integer>();    
                    nodes.add(i*grid[0].length + j);
                    traversed[i][j] = true;
                    while(!nodes.isEmpty()){
                        int temp = nodes.get(0);
                        nodes.remove(0);
                        int k = temp/grid[0].length;
                        int l = temp%grid[0].length;
                        if(k>0){
                            if(!traversed[k-1][l] && grid[k-1][l]=='1') nodes.add((k-1)*grid[0].length + l);
                            traversed[k-1][l] = true;
                        }
                        if(k<grid.length-1){
                            if(!traversed[k+1][l] && grid[k+1][l]=='1') nodes.add((k+1)*grid[0].length + l);
                            traversed[k+1][l] = true;
                        }
                        if(l>0){
                            if(!traversed[k][l-1] && grid[k][l-1]=='1') nodes.add(k*grid[0].length + l - 1);
                            traversed[k][l-1] = true;
                        }
                        if(l<grid[0].length-1){
                            if(!traversed[k][l+1] && grid[k][l+1]=='1') nodes.add(k*grid[0].length + l + 1);
                            traversed[k][l+1] = true;
                        }
                    }
                }
                
            }
        }
        return result;
        
    }
}