public class Solution {
    public int numIslands(char[][] grid) {
        //union find
        if(grid.length==0)  return 0;
        if(grid[0].length==0)   return 0;
        int result = 0;
        int[][] root = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++)
                root[i][j] = i*grid[0].length + j;
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    if(i>0 && j>0){
                        if(grid[i-1][j]=='1'&&grid[i][j-1]=='1'){
                            root[i][j] = (i-1)*grid[0].length+j;
                            if(!findroot(root, (i-1)*grid[0].length+j, i*grid[0].length+j-1)){
                                result--;
                                merge(root, (i-1)*grid[0].length+j, i*grid[0].length+j-1);
                            }
                        }else if(grid[i-1][j]=='1'){
                            root[i][j] = (i-1)*grid[0].length+j;
                        }else if(grid[i][j-1]=='1'){
                            root[i][j] = i*grid[0].length+j-1;
                        }else   result++;
                    }else if(i>0 && j==0){
                        if(grid[i-1][j]=='1'){
                            root[i][j] = (i-1)*grid[0].length+j;
                        }else   result++;
                    }else if(j>0 && i==0){
                        if(grid[i][j-1]=='1'){
                            root[i][j] = i*grid[0].length+j-1;
                        }else   result++;
                    }else{
                        result++;
                    }
                }
            }
        }
        return result;
    }
    
    private boolean findroot(int[][] root, int x, int y){
        while(x!=root[x/root[0].length][x%root[0].length]){
            x=root[x/root[0].length][x%root[0].length];
        }
        while(y!=root[y/root[0].length][y%root[0].length]){
            y=root[y/root[0].length][y%root[0].length];
        }
        return x == y;
    }
    
    private void merge(int[][] root, int x, int y){
        while(x!=root[x/root[0].length][x%root[0].length]){
            x=root[x/root[0].length][x%root[0].length];
        }
        while(y!=root[y/root[0].length][y%root[0].length]){
            y=root[y/root[0].length][y%root[0].length];
        }
        root[y/root[0].length][y%root[0].length] = x;
        return;
    }
}