/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] temp = new char[4];
    int count = 0;
    int head = 0;
    public int read(char[] buf, int n) {
        int result = n;
        while(n>0){
            if(this.count != this.head){
                buf[result-n] = temp[this.head];
                this.head++;
                n--;
            }else{
                this.count = read4(this.temp);
                if(this.count==0)   break;
                this.head = 0;
            }
        }
        return result-n;
    }
}