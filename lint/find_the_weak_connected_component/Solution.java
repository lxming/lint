package lint.find_the_weak_connected_component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import lint.common.DirectedGraphNode;

public class Solution {
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(DirectedGraphNode node: nodes) {
            for(DirectedGraphNode neighbor: node.neighbors) {
                union(map, node.label, neighbor.label);
            }
        }
        HashMap<Integer,ArrayList<Integer>> connected = new HashMap<Integer,ArrayList<Integer>> ();
        for(DirectedGraphNode node: nodes) {
            int p = find(map, node.label);
            if (connected.get(p)==null) {
                connected.put(p, new ArrayList<Integer>(Arrays.asList(node.label)));
            }
            else {
                connected.get(p).add(node.label);
            }
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(List<Integer> c: connected.values()) {
            Collections.sort(c);
            result.add(c);
        }
        return result;
    }
    
    Integer find(HashMap<Integer,Integer> map, int label) {
        if (!map.containsKey(label)) {
            map.put(label, label);
            return label;
        }
        else {
            int parent = map.get(label);
            while(parent!=label) {
                label = parent;
                parent = map.get(label);
            }
            return parent;
        }
    }
    
    void union(HashMap<Integer,Integer> map, int label1, int label2) {
            Integer p1 = find(map, label1);
            Integer p2 = find(map,label2);
            if (p1<p2) {
                map.put(p2,p1);
            }
            else if (p2<p1) {
                map.put(p1,p2);
            }
        
    }
}
