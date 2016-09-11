public class Solution {
    public boolean validUtf8(int[] data) {
        int head = 0;
        while(head<data.length){
            if(data[head]<128){
                head++;
            }else{
                int tmp = data[head]-128;
                int cnt = 0;
                while(tmp>=64){
                    tmp = 2 * (tmp - 64);
                    cnt++;
                }
                if(cnt==0 || cnt>=7)  return false;
                //if(head+cnt+1>data.length)  return false;
                head++;
                while(cnt>0){
                    if(head>=data.length)   return false;
                    if(data[head]>191 || data[head]<128)    return false;
                    head++;
                    cnt--;
                }
            }
        }
        return true;
    }
}