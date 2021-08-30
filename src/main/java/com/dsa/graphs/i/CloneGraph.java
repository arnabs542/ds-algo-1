package com.dsa.graphs.i;

import java.util.*;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 * int label;
 * List<UndirectedGraphNode> neighbors;
 * UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode A) {

        //map of node -> clonedNode
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>(); //store cloned nodes to avoid recreating again
        map.put(A, new UndirectedGraphNode(A.label));

        //queue to do BFS
        Deque<UndirectedGraphNode> deque = new ArrayDeque<>();
        deque.add(A);

        while (!deque.isEmpty()) {

            UndirectedGraphNode node = deque.pollFirst();
            UndirectedGraphNode cloned = map.get(node); //get the cloned node, will not be null because we are cloning before pushing to deque

            for (UndirectedGraphNode nbr : node.neighbors) { //iterate all neighbors of node and clone them

                UndirectedGraphNode clonedNbr = map.get(nbr);
                if (clonedNbr == null) { //no clone yet, also serves as visited array logic
                    deque.addLast(nbr);

                    clonedNbr = new UndirectedGraphNode(nbr.label); //create clone
                    map.put(nbr, clonedNbr); //put in map
                }
                cloned.neighbors.add(clonedNbr); //update cloned node's neighbors
            }
        }
        return map.get(A);
    }

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}

