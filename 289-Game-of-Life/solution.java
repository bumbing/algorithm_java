public class Solution {
    public void gameOfLife(int[][] board) {
        //0=dead, 1=live, 2=live->dead, 3=dead->live
        if(board==null || board.length==0 || board[0].length==0)    return;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int temp = countLife(board, i, j);
                board[i][j] = changeLife(board[i][j], temp);
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] %= 2;
            }
        }
        return;
    }
    
    public int countLife(int[][]board, int m, int n){
        int cnt = 0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int xlen = board.length, ylen=board[0].length;
        for(int i=0; i<dx.length; i++){
            int nx=m+dx[i], ny=n+dy[i];
            if(nx<0 || ny<0 || nx>=xlen || ny>=ylen)    continue;
            if(board[nx][ny]==1 || board[nx][ny]==2)    cnt++;
        }
        return cnt;
    }
    
    public int changeLife(int num, int cnt){
        int[] nums = {0, 0, 1, 1, 0, 0, 0, 0, 0};
        if(num==0 && cnt==3){
            return 3;
        }
        if(num==1){
            return nums[cnt];
        }
        
        return num;
    }
}