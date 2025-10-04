package DataStructure.Graph;

import java.util.*;

/**
 * Basic Graph Implementation with Adjacency List
 */
public class BasicGraph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    private boolean isDirected;

    // Constructor
    @SuppressWarnings("unchecked")
    public BasicGraph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        this.adjacencyList = new LinkedList[vertices];
        
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        
        // If undirected graph, add edge in both directions
        if (!isDirected) {
            adjacencyList[destination].add(source);
        }
    }

    // Remove edge from the graph
    public void removeEdge(int source, int destination) {
        adjacencyList[source].remove(Integer.valueOf(destination));
        
        if (!isDirected) {
            adjacencyList[destination].remove(Integer.valueOf(source));
        }
    }

    // Check if edge exists
    public boolean hasEdge(int source, int destination) {
        return adjacencyList[source].contains(destination);
    }

    // Get neighbors of a vertex
    public List<Integer> getNeighbors(int vertex) {
        return new ArrayList<>(adjacencyList[vertex]);
    }

    // Get degree of a vertex
    public int getDegree(int vertex) {
        return adjacencyList[vertex].size();
    }

    // Get number of vertices
    public int getVertices() {
        return vertices;
    }

    // Get number of edges
    public int getEdges() {
        int edges = 0;
        for (LinkedList<Integer> list : adjacencyList) {
            edges += list.size();
        }
        return isDirected ? edges : edges / 2;
    }

    // Print the graph
    public void printGraph() {
        System.out.println("Graph Representation (Adjacency List):");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (Integer neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    /**
     * Breadth First Search (BFS)
     */
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        
        System.out.println("BFS starting from vertex " + startVertex + ":");
        
        visited[startVertex] = true;
        queue.add(startVertex);
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");
            
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    /**
     * Depth First Search (DFS) - Recursive
     */
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        System.out.println("DFS starting from vertex " + startVertex + ":");
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        
        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    /**
     * Depth First Search (DFS) - Iterative
     */
    public void dfsIterative(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("DFS (Iterative) starting from vertex " + startVertex + ":");
        
        visited[startVertex] = true;
        stack.push(startVertex);
        
        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");
            
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }

    /**
     * Check if graph is connected (for undirected graphs)
     */
    public boolean isConnected() {
        if (isDirected) {
            System.out.println("Connectivity check is for undirected graphs only");
            return false;
        }
        
        boolean[] visited = new boolean[vertices];
        dfsRecursive(0, visited);
        
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    /**
     * Find shortest path using BFS (for unweighted graphs)
     */
    public List<Integer> shortestPath(int source, int destination) {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current == destination) {
                break;
            }
            
            for (int neighbor : adjacencyList[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }
        
        // Reconstruct path
        List<Integer> path = new ArrayList<>();
        int current = destination;
        while (current != -1) {
            path.add(0, current);
            current = parent[current];
        }
        
        return path.get(0) == source ? path : new ArrayList<>();
    }

    /**
     * Detect cycle in undirected graph using DFS
     */
    public boolean hasCycle() {
        if (isDirected) {
            System.out.println("Cycle detection for undirected graphs only");
            return false;
        }
        
        boolean[] visited = new boolean[vertices];
        
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        
        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                if (hasCycleUtil(neighbor, visited, vertex)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    /**
     * Topological Sort (for directed acyclic graphs)
     */
    public List<Integer> topologicalSort() {
        if (!isDirected) {
            System.out.println("Topological sort is for directed graphs only");
            return new ArrayList<>();
        }
        
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result;
    }

    private void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        
        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }
        
        stack.push(vertex);
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Basic Graph Implementation ===\n");
        
        // Create an undirected graph
        BasicGraph undirectedGraph = new BasicGraph(6, false);
        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(0, 2);
        undirectedGraph.addEdge(1, 3);
        undirectedGraph.addEdge(2, 3);
        undirectedGraph.addEdge(2, 4);
        undirectedGraph.addEdge(3, 4);
        undirectedGraph.addEdge(3, 5);
        undirectedGraph.addEdge(4, 5);
        
        System.out.println("Undirected Graph:");
        undirectedGraph.printGraph();
        System.out.println("Number of vertices: " + undirectedGraph.getVertices());
        System.out.println("Number of edges: " + undirectedGraph.getEdges());
        System.out.println("Is connected: " + undirectedGraph.isConnected());
        System.out.println("Has cycle: " + undirectedGraph.hasCycle());
        
        undirectedGraph.bfs(0);
        undirectedGraph.dfs(0);
        undirectedGraph.dfsIterative(0);
        
        List<Integer> shortestPath = undirectedGraph.shortestPath(0, 5);
        System.out.println("Shortest path from 0 to 5: " + shortestPath);
        System.out.println();
        
        // Create a directed graph
        BasicGraph directedGraph = new BasicGraph(6, true);
        directedGraph.addEdge(5, 2);
        directedGraph.addEdge(5, 0);
        directedGraph.addEdge(4, 0);
        directedGraph.addEdge(4, 1);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 1);
        
        System.out.println("Directed Graph:");
        directedGraph.printGraph();
        
        directedGraph.bfs(5);
        directedGraph.dfs(5);
        
        List<Integer> topologicalOrder = directedGraph.topologicalSort();
        System.out.println("Topological sort: " + topologicalOrder);
    }
}
