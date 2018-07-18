import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        return helper(node, new HashMap<>());
    }

    public UndirectedGraphNode helper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        map.put(node.label, new UndirectedGraphNode(node.label));
        UndirectedGraphNode clonedNode = map.get(node.label);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clonedNode.neighbors.add(helper(neighbor, map));
        }
        return clonedNode;
    }

    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
