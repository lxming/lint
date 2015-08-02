package lint;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class RecoverSorted extends TestCase{

	/**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        int p = 0;
        for(int i=0; i<nums.size()-1; i++){
            if (nums.get(i)>nums.get(i+1)) {
                p=i;
                break;
            }
        }
        reverse(nums,0,p);
        reverse(nums, p+1, nums.size()-1);
        reverse(nums,0, nums.size()-1);
    }
    
    void reverse(ArrayList<Integer> nums, int s, int e) {
        for(int i=s, j=e; i<j; i++, j--) {
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
        }
    }
    
    public void testSample() {
    	ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(4,5,1,2,3));
    	this.recoverRotatedSortedArray(al);
    	assertTrue(1==al.get(0));
    	
    }
}
