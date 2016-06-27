public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C-A) * (D-B) + (G-E) * (H-F) - overlap(A, C, E, G) * overlap(B, D, F, H);
    }
    
    private int overlap(int head1, int tail1, int head2, int tail2){
        if(head1 >= tail2 || head2 >= tail1)    return 0;
        return Math.min(tail1, tail2) - Math.max(head1, head2);
    }
}