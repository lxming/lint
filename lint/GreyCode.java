package lint;

import java.util.ArrayList;

import junit.framework.TestCase;

public class GreyCode extends TestCase{
	/**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n==0) {
            result.add(0);
        }
        else {
            ArrayList<Integer> remainder = grayCode(n-1);
            result.addAll(remainder);
            int x = 1<<n;
            for(int r: remainder) {
                result.add((x&r));
            }
        }
        return result;
            
    }
    
    public void testSample() {
    	assertTrue(this.grayCode(1).size()==2);
    }
}
