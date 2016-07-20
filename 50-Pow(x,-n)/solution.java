public class Solution {
    public double myPow(double x, int n) {
        if(n==0)    return 1;
        if(x==1 || x==0)    return x;
        boolean positive = (n>0);
        long m = n;
        m = Math.abs(m);
        double temp = x;
        double result = 1;
        while(m>0){
            if(m%2==1)  result *= temp;
            temp *= temp;
            m>>=1;
        }
        return (positive)?result:1/result;
    }
}