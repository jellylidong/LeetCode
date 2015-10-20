import java.util.*;
public class Problem133_Clone_Graph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hash = new HashMap<>();
        return cloneGraph(node, hash);
            
        
    }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> hash){
        if(node == null)
            return null;
        if(hash.containsKey(node))
            return hash.get(node);
        int label = node.label;
        UndirectedGraphNode root = new UndirectedGraphNode(label);
        hash.put(node, root);
        for(UndirectedGraphNode n: node.neighbors){
            root.neighbors.add(cloneGraph(n, hash));
        }
        return root;
    }
}
