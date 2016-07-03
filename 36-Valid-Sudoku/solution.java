public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            Set<Character> set = new HashSet<>();
            for(int j=0; j<9; j++){
                if(set.contains(board[i][j]))   return false;
                if(board[i][j]!='.')    set.add(board[i][j]);
            }
            set.clear();
            for(int j=0; j<9; j++){
                if(set.contains(board[j][i]))   return false;
                if(board[j][i]!='.')    set.add(board[j][i]);
            }
            set.clear();
            for(int x=0; x<3; x++){
                for(int y=0; y<3; y++){
                    char temp = board[i-i%3+x][i%3*3+y];
                    if(set.contains(temp)) return false;
                    if(temp!='.')   set.add(temp);
                }
            }
        }
        return true;
    }
}