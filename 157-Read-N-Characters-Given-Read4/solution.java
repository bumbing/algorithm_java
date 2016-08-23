/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        n = Math.min(n, buf.length);
        char[] temp = new char[4];
        int count = 0, index = 0;
        int leftChar = n;
        boolean eof = false;
        while(leftChar!=0){
            if(count==0){
                if(eof) break;
                count = read4(temp);
                if(count<4)    eof=true;
            }else{
                buf[index] = temp[4-count];
                count--;
                leftChar--;
                index++;
            }
        }
        return n-leftChar;
    }
}