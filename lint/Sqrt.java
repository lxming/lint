package lint;

import java.math.BigInteger;

import junit.framework.TestCase;

public class Sqrt extends TestCase{
	 public int sqrt(int x) {
	        if (x<=1) {
	            return x;
	        }
	        BigInteger bx = BigInteger.valueOf(x);
	        int l=1, r = x-1;
	        while(l<r) {
	            int m = (l+r)/2;
	            BigInteger v = BigInteger.valueOf(m).multiply(BigInteger.valueOf(m));
	            if (v.compareTo(bx)==0) {
	                return m;
	            }
	            else if (v.compareTo(bx)<0) {
	                l=m+1;
	            }
	            else {
	                r=m-1;
	            }
	        }
	        return l*l>x?l-1:l;
	    }
	
	public void testSample() {
		assertEquals(3, sqrt(9));
		assertEquals(31622, sqrt(999999999));
	}
}
