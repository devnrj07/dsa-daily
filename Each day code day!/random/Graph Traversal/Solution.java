import java.util.HashMap;

public class Solution{
    public static void main(String[] args) {
        createGraph();
    }
    static Graph createGraph() {
        Graph graph = new Graph();
        graph.addNode("Bob");
        graph.addNode("Alice");
        graph.addNode("Mark");
        graph.addNode("Rob");
        graph.addNode("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }

}

class Graph{
    class Node{
        private String label;
        Node(String label){
            this.label = label;
        }
    }

    private Map<Node, List<Node>> adjList;

    Graph(){
        adjList = new HashMap();
    }

    void addNode(String label){
        adjList.putIfAbsent(new Node(label), new ArrayList<>());
    }

    void removeNode(String label){
        Node node = new Node(label);
        adjList.values().stream().forEach(x -> x.remove(node));
        adjList.remove(new Node(label));
    }

    void addEdge(String label1, String label2){
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);
        adjList.get(node1).push(node2);
        adjList.get(node2).push(node1);
    }

    void removeEdge(String label1, String label2){
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);

        List<Node> newNode1 = adjList.get(node1);
        List<Node> newNode2 = adjList.get(node2);

        if(newNode1 != null){
            newNode1.remove(newNode2);
        }
        if(newNode2 != null){
            newNode2.remove(newNode1);
        }
    }

    List<Vertex> getAdjNodes(String label) {
        return adjVertices.get(new Node(label));
    }

    //DFS A depth-first traversal starts at an arbitrary root vertex and explores vertices as deeper as possible along each branch before exploring vertices at the same level.
    Set<String> depthFirstTraversal(Graph graph, String root){
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<>();
       //we're using a Stack to store the vertices that need to be traversed.
        stack.push(root);
        while(!stack.isEmpty()){
            String node = stack.pop();
            if(!visited.contains(node)){
                visited.add(node);
                for(Node node : graph.getAdjNodes(node)){
                    stack.push(node.label);
                }
            }
    
        }

        return visited;
    }

}


//BFS :  explores all neighboring vertices at the same level before going deeper in the graph. 
Set<String> breadthFirstTraversal(Graph graph, String root) {
    Set<String> visited = new LinkedHashSet<String>();
    Queue<String> queue = new LinkedList<String>();
    queue.add(root);
    visited.add(root);
    while (!queue.isEmpty()) {
        String node = queue.poll();
        for (Node n : graph.getAdjVertices(node)) {
            if (!visited.contains(n.label)) {
                visited.add(n.label);
                queue.add(n.label);
            }
        }
    }
    return visited;
}