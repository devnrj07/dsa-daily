/*Find longest sequence of zeros in binary representation of an integer.

Description:

A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N. */

public class Solution{
    public static void main(String[] args) {
        
    }

    static int binaryGap(int N){
        //if N < 2 it means we have the only bit which may be set to 1 so we can't have the gap here.
    if (N < 2) { return 0; }
    
    // Init counters of bits for a current gap and a longest gap
    int max = 0, count = 0;
    
    /* N % 2 != 0 only in case we have the first bit set to 1.
     
     Example:
     0000 0001 = 1
     0000 0011 = 3
     0000 0111 = 7
     0000 1111 = 15
     and so on.
     
     N % 2 == 0 only in case we have the first bit set to 0.
     
     Example:
     0000 0000 = 0
     0000 0010 = 2
     0000 0110 = 6
     0000 1110 = 14
     and so on.
     
     Division of N by 2 do the same as right shift operation that is move all the bits right to one position, 
     but integer division operation exists in all programming languages when bit shift operations usually have
     low level languages only so division by 2 is more general solution.
     Thus this line means "repeat while the first bit is 0 right shift all the bits to one position.
    */
    while (N % 2 == 0) { N /= 2; }
    
    // Repeat while we have 1th bits in the N variable
    while (N > 0) {
        
        // if the first bit of the N is 1 it means we reached the end of the current gap
        if (N % 2 == 1) {
            
            // if the current gap is bigger than the max gap make it the max
            if (count > max) { max = count; }
            
            // clean the counter to count the next gap length
            count = 0;
        }
        else {
            // if the first bit of the N is 0 just count the current bit to the current gap
            count++;
        }
        // right shift to work with a next bit
        N /= 2;
    }
    return max;
}
}