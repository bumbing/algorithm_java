public class Solution {
    public int compareVersion(String version1, String version2) {
        int l1 = version1.length();
    int l2 = version2.length();
    int v1 = 0;
    int v2 = 0;
    
    int i1 = 0;
    int i2 = 0;
    
    while (i1 < l1 || i2 < l2){
    	   	
    	while (i1 < l1 && version1.charAt(i1)!='.'){
        	v1 = 10*v1 + (version1.charAt(i1) - '0') ;
        	i1++;
    	}
    	
    	while (i2 < l2 && version2.charAt(i2)!='.'){
        	v2 = 10*v2 + (version2.charAt(i2) - '0') ;
        	i2++;
    	}
        	
        if (v1 > v2) return 1;
        else if (v1 < v2) return -1 ;
        else {
            v1 = 0;
            v2 = 0;
            i1++;
            i2++;
        }
    }

    return 0;
    }
}