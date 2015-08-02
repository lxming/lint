package lint;

import junit.framework.TestCase;

public class RemoveDuplicate extends TestCase{
	public int removeDuplicates(int[] nums) {
        if (nums.length<=2) {
            return nums.length;
        }
        int slow=0, fast=0;
        while(fast<nums.length) {
            if (fast<nums.length-2 && nums[fast]==nums[fast+1] && nums[fast]==nums[fast+2]) {
                fast++;
            }
            else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }
	
	public void testSample() {
		int[] input = new int[]{-1014,-1014,-1014,-1006,-1005,-1004,-1002,-1001,-1000,-999,-999,-998,-997,-997,-997,-996,-995,-995,-994,-993,-992,-992,-992,-992,-991,-991,-991};
		int x = this.removeDuplicates(input);
		assertTrue(x>10);
	}
}
