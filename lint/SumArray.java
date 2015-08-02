package lint;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class SumArray extends TestCase {
	public ArrayList<Integer> subarraySumClosest(int[] nums) {
        int[] sums = new int[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            sums[i+1]=sums[i] + nums[i];
        }
        int min = Integer.MAX_VALUE;
        int s = 0;
        int e = 0;
        for(int i=0;i<nums.length; i++) {
            for(int j=i+1; j<nums.length+1; j++) {
                if (Math.abs(sums[j]-sums[i])<min) {
                    min=Math.abs(sums[j]-sums[i]);
                    s = i;
                    e = j-1;
                }
            }
        }
        return new ArrayList<Integer>(Arrays.asList(s,e));
    }
	
	public void testSample() {
		int[] ex = new int[]{-3,1,1,-3,5};
		ArrayList<Integer> r = this.subarraySumClosest(ex);
		assertTrue(2 == r.get(1));
	}
}
