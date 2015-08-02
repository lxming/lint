package lint;

import junit.framework.TestCase;

public class Aplusb extends TestCase {
	public int aplusb(int a, int b) {
        int result = 0;
        for(int i=0; i<32; i++) {
            result = (((a &1) + (b &1))<<i) + result;
            a=a>>1;
            b=b>>1;
        }
        return result;
    }
	
	public void testSample() {
		assertEquals(3, aplusb(1,2));
	}
}
