package lint;

import java.util.ArrayList;

import junit.framework.TestCase;

public class MinDiffSubArray extends TestCase {
	public int maxDiffSubArrays(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n<=1){
            return 0;
        }
        int[] leftMin = new int[n];
        leftMin[0] = nums.get(0);
        int endinghere = nums.get(0);
        for(int i=1; i<n; i++) {
            endinghere = Math.min(nums.get(i), endinghere + nums.get(i));
            leftMin[i]=Math.min(leftMin[i-1], endinghere);
        }
        int[] leftMax = new int[n];
        leftMax[0] = nums.get(0);
        endinghere = nums.get(0);
        for(int i=1; i<n; i++) {
            endinghere = Math.max(nums.get(i), endinghere + nums.get(i));
            leftMax[i]=Math.max(leftMax[i-1], endinghere);
        }
        
        int[]rightMin = new int[n];
        rightMin[n-1] = nums.get(n-1);
        int startinghere = nums.get(n-1);
        for(int i=n-2; i>=0; i--) {
            startinghere = Math.min(nums.get(i), startinghere + nums.get(i));
            rightMin[i]= Math.min(rightMin[i+1], startinghere);
        }
        
        int[]rightMax = new int[n];
        rightMax[n-1] = nums.get(n-1);
        startinghere = nums.get(n-1);
        for(int i=n-2; i>=0; i--) {
            startinghere = Math.max(nums.get(i), startinghere + nums.get(i));
            rightMax[i]= Math.max(rightMax[i+1], startinghere);
        }
        
        int diff = 0;
        for (int i=0; i<n-1; i++) {
            diff = Math.max(diff, Math.abs(leftMax[i] - rightMin[i+1]));
            diff = Math.max(diff, Math.abs(leftMin[i] - rightMax[i+1]));
        }
        return diff;
    }
	
	public void testSample() {
		ArrayList<Integer> sample = new ArrayList<Integer>();
		sample.add(-5);
		sample.add(-4);
		assertEquals(1, this.maxDiffSubArrays(sample));
	}
}
