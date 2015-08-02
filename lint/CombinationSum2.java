package lint;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

public class CombinationSum2  extends TestCase{
	/*
    * @param num: Given the candidate numbers
    * @param target: Given the target number
    * @return: All the combinations that sum to target
    */
   public List<List<Integer>> combinationSum2(int[] num, int target) {
       Arrays.sort(num);
       return helper(num, 0, target);
       
   }
   List<List<Integer>> helper(int[] candidates, int idx, int target) {
       List<List<Integer>> result = new LinkedList<List<Integer>>();
       int prev = 0;
       for(int i=idx; i<candidates.length; i++) {
           if (prev==candidates[i]) {
               continue;
           }
           if (target>candidates[i]) {
               List<List<Integer>> found = helper(candidates, i+1, target-candidates[i]);
               for(List<Integer>l: found) {
                   l.add(0,candidates[i]);
                   result.add(l);
               }
           }
           else if(target==candidates[i]){
               result.add(new LinkedList<Integer>(Arrays.asList(target)));
           }
           prev = candidates[i];
       }
       return result;
   }
   
   public void testSample() {
	   int[] num = new int[]{1,1,6};
	   assertEquals(1, this.combinationSum2(num, 7).size());
   }
}
