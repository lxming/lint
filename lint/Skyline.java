package lint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import junit.framework.TestCase;

public class Skyline  extends TestCase {
	public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        if (buildings.length==0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        TreeMap<Integer, List<Building>> edges = new TreeMap<Integer, List<Building>>();
        for(int[] building: buildings) {
            Building b = new Building(building[0],building[1], building[2]);
            if (edges.get(b.start)==null) {
                edges.put(b.start, new ArrayList<Building>());
            }
            edges.get(b.start).add(b);
            if (edges.get(b.end)==null) {
                edges.put(b.end, new ArrayList<Building>());
            }
            edges.get(b.end).add(b);
        }
        Building start = null;
        PriorityQueue<Building> queue = new PriorityQueue<Building>();
        for(Map.Entry<Integer, List<Building>> edge: edges.entrySet()){
            for (Building b: edge.getValue()) {
                if (b.start==edge.getKey()) {
                    queue.add(b);
                }
                else {
                    queue.remove(b);
                }
            }
            if (queue.size()==0) {
                result.add(new ArrayList<Integer>(Arrays.asList(start.start, edge.getKey(), start.height)));    
            }
            else{
                Building head = queue.peek();
                if (start == null) {
                    start = head;    
                }
                else if (start.height!=head.height) {
                    result.add(new ArrayList<Integer>(Arrays.asList(start.start, edge.getKey(), start.height)));    
                    start = head;
                }
            }
        }
        return result;
    }
	
	public void testSample() {
		int[][] sample = new int[][]{{1, 3, 3},{2, 4, 4},{5, 6, 1}};
		 ArrayList<ArrayList<Integer>> result = this.buildingOutline(sample);
		 assertEquals(3, result.size());
	}
    
    
  
}
class Building implements Comparable<Building>{
    int start;
    int end;
    int height;
    Building(int start, int end, int height) {
        this.start = start;
        this.end = end;
        this.height = height;
    }
    public int compareTo(Building other) {
        return other.height - this.height;
    }
}