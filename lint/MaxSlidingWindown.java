package lint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import junit.framework.TestCase;

public class MaxSlidingWindown   extends TestCase{
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        for(int i=0; i<k; i++) {
            queue.add(nums[i]);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(queue.peek());
        for(int i=k; i<nums.length; i++) {
        	if (nums[k]>queue.peek()) {
        		queue.clear();
        		queue.add(nums[k]);
        	}
        	else {
        		queue.add(nums[k]);
        		queue.remove(nums[i-k]);
        	}
            result.add(queue.peek());
        }
        return result;
    }
	
	public void testSample() {
		int[]nums = new int[] {1,2,7,7,2};
		ArrayList<Integer> result = this.maxSlidingWindow(nums, 1);
	}
}
