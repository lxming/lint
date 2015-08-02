package lint;

import junit.framework.TestCase;

public class FastPower extends TestCase{
	public int fastPower(int a, int b, int n) {
        int m = a%b;
        int total=1;
        int t = m;
        for(int i=0; i<32; i++) {
            if ((n&(1<<i))!=0){
                total = total * t;
                
            }
            t = t*t;
        }
        return total%b;
    }
	
	public void testSample(){
		assertEquals(5, this.fastPower(3, 7, 5));
	}
}
