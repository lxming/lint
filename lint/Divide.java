package lint;

import junit.framework.TestCase;

public class Divide  extends TestCase{
	public int divide(int dividend, int divisor) {
        if (divisor==0) {
            return 2147483647;
        }
        boolean positive = true;
        long x=dividend;
        long y=divisor;
        if (dividend<0) {
            x = -x;
            positive = !positive;
        }
        if (divisor<0) {
            y = -y;
            positive =!positive;
        }
        
        long remainder = x;
        long result = 0;
        while(remainder>=y) {
            long t = y;
            int i=0;
            while(remainder>=t) {
                i++;
                t=y<<i;
            }
            result=result + (1l<<(i-1));
            remainder = remainder - (y<<(i-1));
        }
        result = positive?result:-result;
        if (result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
            return 2147483647;
        }
        return (int)result;
    }
	 
	 public void testSample() {
		 //assertEquals(10, this.divide(10,1));
		 assertEquals(-2147483648, this.divide(-2147483648,-1));
	 }
}
