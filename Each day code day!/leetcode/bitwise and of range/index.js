function rangeBitwiseAnd(m, n) {
    // number of shifts we had to make
    let i = 0;
	
    // go until m and n are equal
    while (m !== n) {
        // right shift both m and n
        m >>= 1;
        n >>= 1;
        // that's 1 more shift
        i++;
    }
	
    // pad 0's on right of m by right shifting by i
    return (m <<= i);
}

/*

super explanation:
the idea here is to keep right shifting m and n until they are equal.
we do this, because, until they are equal, the bits that are lost in the right shift will ultimately end up yielding a 0 bit on the ANDs anyways.

Example:

let m = 27, n = 31

    27 = 11011
    31 = 11111

1st shift
1101
1111
shifts = 1

2nd shift
110
111
shifts = 2

3rd shift
11
11
shifts = 3

They are now equal, and that required 3 shifts.

We take that 11, and after left shifting 3 times, it becomes 11000 which is 24.

The reason this is the answer, is because if we were to loop from m and n, ANDing everything, everything to the right of that 1 would become a zero anyways, due to differing bits, since they weren't equal until this point anyways.	

*/