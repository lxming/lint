package lint;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import junit.framework.TestCase;

public class WordLadder extends TestCase{
	public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }
        HashSet<String> used = new HashSet<String>();
        int depth=1;
        LinkedList<String>queue = new LinkedList<String>();
        queue.add(start);
        while(queue.size()>0) {
            depth++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String s = queue.poll();
                char[] chars = s.toCharArray();
                for(int j=0; j<chars.length; j++) {
                    char oldchar = chars[j];
                    for(char k='a'; k<='z'; k++) {
                        if (k==oldchar) {
                            continue;
                        }
                        else {
                            chars[j] = k;
                            String guess = new String(chars);
                            if (guess.equals(end)){
                                return depth;
                            }
                            if (dict.contains(guess) && !used.contains(guess)) {
                                queue.add(guess);
                            }
                        }
                    }
                    chars[j] = oldchar;
                }
            }
        }
        return -1;
    }
	
	public void testSample() {
		HashSet<String> dict = new HashSet<String> ();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		assertEquals(2, this.ladderLength("a", "c", dict));
	}
}
