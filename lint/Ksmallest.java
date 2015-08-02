package lint;

import java.util.HashSet;
import java.util.PriorityQueue;

import junit.framework.TestCase;


public class Ksmallest extends TestCase{
	
	public int kthSmallest(int[][] matrix, int k) {
	       
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Item> queue = new PriorityQueue<Item>();
        HashSet<Item>boundary = new HashSet<Item>();
        Item item = new Item(0,0,matrix[0][0]);
        queue.add(item);
        boundary.add(item);
        for(int i=1; i<k; i++) {
            Item curr= queue.poll();
            if (curr.y<n-1) {
                Item right = new Item(curr.x, curr.y+1, matrix[curr.x][curr.y+1]);
                if (!boundary.contains(right)) {
                    queue.add(right);
                    boundary.add(right);
                }
            }
            if (curr.x<m-1) {
                Item below = new Item(curr.x+1, curr.y, matrix[curr.x+1][curr.y]);
                if (!boundary.contains(below)) {
                    queue.add(below);
                    boundary.add(below);
                }
            }
            boundary.remove(curr);
        }
        return queue.poll().value;
	}

    	public void testSample() {
    		int[][] m = new int[][] {{1,1,1}};
    		assertEquals(1, this.kthSmallest(m, 1));
    		m = new int[][] {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8}};
    		assertEquals(7, this.kthSmallest(m, 19));
    		
    		
    	}
    }

class Item implements Comparable<Item>{
    int x; 
    int y;
    int value;
    Item(int x, int y, int value) {
        this.x=x;
        this.y=y; 
        this.value = value;
    }
	public int compareTo(Item other) {
		return this.value - other.value;
	}
    
    
}

