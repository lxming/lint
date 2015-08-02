package lint;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class MajorityII extends TestCase {
	public int majorityNumber(ArrayList<Integer> nums) {
        int counter1 = 0;
        int n1=0;
        int counter2=0;
        int n2 = 0;
        for(int n: nums) {
            if (counter1 == 0 || n1== n) {
                n1 = n;
                counter1++;
             
            }
            else if (counter2 ==0 || n2==n) {
                counter2=counter2+2;
                n2=n;
                counter2++;
            }
            else {
                counter1--;
                counter2--;
                if (counter1==0) {
                    n1 = n;
                    counter1++;
                }
                else if (counter2==0) {
                    n2=n;
                    counter2++;
                }
            }
        }
        int c1 = 0;
        for(int n:nums) {
            if (n==n1) {
                c1++;
            }
        }
        return (c1>nums.size()/3)?n1:n2;
    }
	
	public void testSample() {
		ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(1,1,1,1,2,2,3,3,4,4,4));
		assertEquals(1, this.majorityNumber(al));
	}
}
