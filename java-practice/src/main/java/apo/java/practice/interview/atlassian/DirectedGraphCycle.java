package apo.java.practice.interview.atlassian;

import java.util.*;

import static org.junit.Assert.assertFalse;

public class DirectedGraphCycle {
    public static void main(String[] args) {
        var dg = new DirectedGraphCycle();
        assertFalse(dg.solution(new int[]{0, 0, 1, 2}, new int[]{1, 2, 3, 3}));
    }

    //nodes in first array[i] are connected to nodes in second array[i]
    //Detect if there is a cycle from any node, if there is a cycle you can get to the starting node after visiting all nodes
    //If there is a cycle and you did not visit all the existing nodes than you assume there is no cycle at all
    //solution(new int[]{3,1,2},new int[]{2,3,1})
    //solution(new int[]{3,1,2,4,4,5},new int[]{2,3,1,5,6,7})
    public boolean solution(int[] a, int[] b) {
        var nodes = new HashMap<Integer, Node>();
        int nodesNum = 0;
        for (int i = 0; i < a.length; i++) {
            Node one;
            if (nodes.containsKey(a[i])) {
                one = nodes.get(a[i]);
            } else {
                nodesNum++;
                one = new Node(a[i]);
                nodes.put(a[i], one);
            }

            Node two;
            if (nodes.containsKey(b[i])) {
                two = nodes.get(b[i]);
            } else {
                nodesNum++;
                two = new Node(b[i]);
                nodes.put(b[i], two);
            }
            one.childs.add(two);
        }

        Node start = nodes.get(a[0]);

        int result = bfs(start);

        return nodesNum == result;

    }

    private int bfs(Node root) {
        var seen = new HashSet<Node>();
        var queue = new LinkedList<Node>();
        queue.offer(root);
        seen.add(root);
        int nodes = 1;
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            for (Node n : curr.childs) {
                if (seen.contains(n)) {
                    return nodes;
                } else {
                    nodes++;
                    queue.offer(n);
                }
            }
        }
        return 0;
    }

    class Node {
        int val;
        List<Node> childs = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

}