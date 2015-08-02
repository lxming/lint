package lint;

import java.util.Comparator;
import java.util.PriorityQueue;

import junit.framework.TestCase;

public class StreamMedian  extends TestCase{
	public int[] medianII(int[] nums) {
        int[] result = new int[nums.length];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            public int compare(Integer v1, Integer v2) {
                return v2-v1;
            }
        }
        );
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(nums.length);
        for(int i=0; i<nums.length; i++) {
            int incoming = nums[i];
            if (maxHeap.size()==minHeap.size()) {
                if(maxHeap.size()==0 || incoming<=minHeap.peek()) {
                    maxHeap.add(incoming);
                }
                else {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(incoming);
                }
            }
            else {
                if(incoming>=maxHeap.peek()) {
                    minHeap.add(incoming);
                }
                else {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(incoming);
                }
            }
            result[i] = maxHeap.peek();
        }
        return result;
    }
	
	public void testSample() {
		int[]nums = new int[]{1,2,3,4,5};
		int[] r= this.medianII(nums);
		assertEquals(5, r[4]);
	}
    
}
