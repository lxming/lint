package lint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

public class WordLadder2  extends TestCase{
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (start.equals(end)) {
            result.add(new ArrayList<String>(Arrays.asList(start)));
            return result;
        }
        dict.remove(start);
        dict.remove(end);
        LinkedList<String>queue = new LinkedList<String>();
        queue.add(start);
        HashMap<String, List<String>> seq = new HashMap<String, List<String>>();
        boolean done = false;
        while(queue.size()>0 && !done) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String s = queue.poll();
                char[] chars = s.toCharArray();
                for(int j=0; j<chars.length; j++) {
                    char oldchar = chars[j];
                    for(char k='a'; k<='z'; k++) {
                        if (oldchar==k) {
                            continue;
                        }
                        else {
                            chars[j] = k;
                            String guess = new String(chars);
                            if (dict.contains(guess)) {
                                queue.add(guess);
                                if (seq.get(guess)==null){
                                    seq.put(guess, new ArrayList<String>(Arrays.asList(s)));
                                }
                                else if (!seq.get(guess).contains(s)){
                                    seq.get(guess).add(s);
                                }
                            }
                            if (guess.equals(end)){
                                done = true;
                                if (seq.get(guess)==null){
                                    seq.put(guess, new ArrayList<String>(Arrays.asList(s)));
                                }
                                else if (!seq.get(guess).contains(s)){
                                    seq.get(guess).add(s);
                                }
                            }
                        }
                    }
                    chars[j] = oldchar;
                }
            }
            
        }
        return flat(seq, start, end);
    }
    
    public  List<List<String>> flat(HashMap<String, List<String>> seq, String start, String end) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if (seq.get(end).contains(start)) {
            result.add(new ArrayList<String>(Arrays.asList(start, end)));
            return result;
        }
        else {
            for (String s: seq.get(end)) {
                for(List<String> l: flat(seq, start, s)) {
                    l.add(end);
                    result.add(l);
                }
            }
        }
        return result;
    }
    
    public void testSample() {
    	HashSet<String> dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("cog");dict.add("dog");dict.add("tot");dict.add("hog");dict.add("hop");dict.add("pot");dict.add("dot");
    	assertEquals(2, this.findLadders("hot", "dog", dict).size());
    }
    
}
