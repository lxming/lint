package lint;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class Sum2zero extends TestCase{
	public ArrayList<Integer> subarraySumClosest(int[] nums) {
        if (nums.length==0){
            return new ArrayList<Integer>();
        }
        else if (nums.length==1) {
            return new ArrayList<Integer>(Arrays.asList(0,0));
        }
        int[] sums = new int[nums.length];
        sums[0]=nums[0];
        for(int i=1; i<nums.length; i++) {
            sums[i]=sums[i-1] + nums[i];
        }
        int[] sumscopy = Arrays.copyOf(sums, sums.length);
        Arrays.sort(sums);
        int v1 = sums[0];
        int v2 = sums[1];
        for(int i=2; i<nums.length; i++) {
            if (Math.abs(sums[i]-sums[i-1])<Math.abs(v1-v2)){
                v1=sums[i-1];
                v2=sums[i];
            }
        }
        
        int i1 = -1;
        int i2 = -1;
        for(int i=0; i<sumscopy.length; i++) {
            if (i1==-1 && sumscopy[i]==v1) {
                i1 = i;
            }
            else if (sumscopy[i]==v2) {
                i2 = i;
            }
        }
        if (i2>i1) {
            return new ArrayList<Integer>(Arrays.asList(i1+1, i2));
        }
        else {
            return new ArrayList<Integer>(Arrays.asList(i2+1, i1));
        }
        
    }
	
	public void testSample() {
		int[] sample = new int[]{5,10,5,3,2,1,1,-2,-4,3};
		assertEquals(new Integer(5), this.subarraySumClosest(sample).get(0));
	}
}
