/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int head = 0, tail = 0, idx = 0;
        boolean eof = false;
        while(n>0){
            if(head==tail){
                if(eof) break;
                head=0;
                tail = read4(temp);
                if(tail<4)  eof = true;
            }else{
                buf[idx] = temp[head];
                idx++;
                head++;
                n--;
            }
        }
        return idx+1;
    }
}