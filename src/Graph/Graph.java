package Graph;

import java.io.*;
import java.util.*;

public class Graph {
    // to read and print
    public static PrintWriter out = new PrintWriter(System.out);
    private static BufferedReader reader = null;

    // to store Node
    private static HashMap<String, Node> adjacencyList = new LinkedHashMap<>();

    private static class Node {
        private String name;
        ArrayList<Node> neighborsList = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }
    }

    private static Node getNode(String nodeName) {
        return adjacencyList.get(nodeName);
    }

    private static void addEdge(String source, String destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.neighborsList.add(d);
    }

    private static void printGraph() {
        for (Map.Entry<String, Node> entry : adjacencyList.entrySet()) {
            Node eachNode = entry.getValue();
            out.print("[" + eachNode.name + "]");
            for (Node neighbors : eachNode.neighborsList) {
                out.print(" --> " + neighbors.name);
            }
            out.println();
        }
    }

    public void readInput(String fileName, boolean isPrintGraph) throws IOException {
        String filePath = new File("").getAbsolutePath() + "/src/Graph/" + fileName;
        out.println("FilePath : " + filePath);
        reader = new BufferedReader(new FileReader(filePath));

        // graph type (directed/undirected)
        String graphType = (reader.readLine().trim());
        out.println("Type of graph : " + graphType);

        boolean isDirected = false;
        if (graphType.trim().toLowerCase().equals("directed")) {
            isDirected = true;
        }

        // Read vertices
        int numberOfVertices = Integer.parseInt(reader.readLine().trim());
        out.println("Number of Vertices : " + numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++) {
            String nodeName = reader.readLine().trim();
            adjacencyList.put(nodeName, new Node(nodeName));
        }

        // Read edges
        int numberOfEdges = Integer.parseInt(reader.readLine().trim());
        out.println("Number of Edges : " + numberOfEdges);
        for (int i = 0; i < numberOfEdges; i++) {
            String[] edgeInfo = reader.readLine().trim().split("\\s+");
            String sourceNode = edgeInfo[0].trim();
            String destinationNode = edgeInfo[1].trim();

            addEdge(sourceNode, destinationNode);
            if (!isDirected) {
                addEdge(destinationNode, sourceNode);
            }
        }

        // if isPrintGraph = true, then print graph
        if (isPrintGraph) {
            printGraph();
        }
        out.flush();
    }

    public static void main(String args[]) throws IOException {
        Graph graph = new Graph();
        graph.readInput("example-1.txt", true); /* (filename, wannaPrintGraph) */
    }
}

/*
    private boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(source);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source.id)) {
            return false;
        }
        visited.add(source.id);
        if (source == destination) return true;
        for (Node childNode : source.neighborsList) {
            if (hasPathDFS(childNode, destination, visited)) {
                return true;
            }
        }
        return false;
    }
 */
