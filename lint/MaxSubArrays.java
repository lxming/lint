package lint;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class MaxSubArrays extends TestCase {
	 /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int[] r1 = this.maxSubArray(nums, 0, nums.size()-1);
        int[] r2 = new int[]{-1,-1, Integer.MIN_VALUE};
        int[] r3 = new int[]{-1,-1, Integer.MIN_VALUE};
        if (r1[0]>0){
            r2 = this.maxSubArray(nums, 0, r1[0]-1);
        }
        if(r1[1]<nums.size()-1) {
            r3 = this.maxSubArray(nums, r1[1]+1, nums.size()-1);
        }
        return r1[2]+Math.max(r2[2], r3[2]);
    }
    
    int[] maxSubArray(ArrayList<Integer> nums, int start, int end) {
        int maxendinghere = nums.get(start);
        int maxsofar = nums.get(start);
        int maxendinghereIdx = start;
        int maxsofarStart = start;
        int maxsofarEnd = start;
        for(int i=start+1; i<=end; i++) {
            maxendinghere = Math.max(nums.get(i),maxendinghere+nums.get(i));
            if (maxendinghere==nums.get(i)){
                maxendinghereIdx = i;
            }
            maxsofar = Math.max(maxsofar, maxendinghere);
            if (maxsofar==maxendinghere) {
                maxsofarStart=maxendinghereIdx;
                maxsofarEnd=i;
            }
        }
        return new int[]{maxsofarStart, maxsofarEnd, maxsofar};
    }
    
    public void testSample() {
    	assertEquals(7, this.maxTwoSubArrays(new ArrayList<Integer>(Arrays.asList(1,3,-1,2,-1,2))));
    }
}
