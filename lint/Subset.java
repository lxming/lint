package lint;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class Subset extends TestCase{
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=S.size(); i++) {
            result.addAll(combine(S,0,i));
        }
        return result;
    }
    
    ArrayList<ArrayList<Integer>> combine(ArrayList<Integer> a, int start, int size) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int neededSize = start+size;
        if (size==0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        else if (neededSize==a.size()) {
            result.add(new ArrayList<Integer>(a.subList(start, neededSize)));
            return result;
        } else {
            for(int i=start; i<=a.size()-size; i++){
                int prefix = a.get(i);
                ArrayList<ArrayList<Integer>> rest = combine(a, i+1, size-1);
                for(ArrayList<Integer> al: rest) {
                    al.add(0, prefix);
                    result.add(al);
                }
            }
        }
        return result;
    }
    
    public void testSample() {
    	ArrayList<Integer> sample = new ArrayList<Integer>(Arrays.asList(1,2,3));
    	assertEquals(8, this.subsets(sample));
    	
    }
}
