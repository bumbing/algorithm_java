public class Solution {
    public void solve(char[][] board) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        if(board==null || board.length==0 || board[0].length==0)    return;
        LinkedList<Integer> node = new LinkedList<>();
        int xlen = board.length, ylen = board[0].length;
        boardInit(board, node);
        while(!node.isEmpty()){
            int loc = node.poll();
            int x = loc / ylen, y = loc % ylen;
            for(int i=0; i<dx.length; i++){
                int nx = x + dx[i], ny = y + dy[i];
                if(nx<0 || nx>=xlen || ny<0 || ny>=ylen)  continue;
                if(board[nx][ny] == 'O'){
                    board[nx][ny] = 'M';
                    node.offer(nx * ylen + ny);
                }
            }
        }
        for(int i=0; i<xlen; i++){
            for(int j=0; j<ylen; j++){
                if(board[i][j]=='M')    board[i][j] = 'O';
                else if(board[i][j]=='O')   board[i][j] = 'X';
            }
        }
        return;
    }
    
    public void boardInit(char[][] board, LinkedList<Integer> node){
        int xlen = board.length, ylen = board[0].length;
        for(int i=0; i<xlen; i++){
            for(int j=0; j<ylen; j++){
                int idx = i * ylen + j;
                if(board[i][j]=='O' && (i==0 || j==0 || i==xlen-1 || j == ylen -1)){
                    board[i][j] = 'M';
                    node.offer(idx);
                }
            }
        }
    }
}