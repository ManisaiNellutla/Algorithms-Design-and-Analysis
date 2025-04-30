import java.util.*;



public class Subsets {



    public static void printSubsets(int[] arr) {

        List<Integer> current = new ArrayList<>();

        generateSubsets(arr, 0, current);

    }



    public static void generateSubsets(int[] arr, int index, List<Integer> current) {

        if (index == arr.length) {

            System.out.println(current);

            return;

        }



        // Include the current element

        current.add(arr[index]);

        generateSubsets(arr, index + 1, current);



        // Exclude the current element

        current.remove(current.size() - 1);

        generateSubsets(arr, index + 1, current);

    }



    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        printSubsets(arr);

    }

}

subset (bscktrscking)
-----------------------------------------------------------------------------------------
import java.util.Arrays;

class GfG {

    // Function to calculate the nth Fibonacci number using memoization
    static int nthFibonacciUtil(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = nthFibonacciUtil(n - 1, memo) + nthFibonacciUtil(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        int result = nthFibonacciUtil(n, memo);  // FIXED: Pass memo array here
        System.out.println(result);  // Output: 5
    }
}
-------------------------------------------------------------------------------------------
import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        // Each item: {weight, value}
        double[][] items = {
            {10, 60},
            {20, 100},
            {30, 120}
        };
        double capacity = 50;

        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b[1] / b[0], a[1] / a[0]));

        double totalValue = 0;

        // Normal for loop
        for (int i = 0; i < items.length; i++) {
            double weight = items[i][0];
            double value = items[i][1];

            if (capacity >= weight) {
                // Take the full item
                totalValue += value;
                capacity -= weight;
            } else {
                // Take fractional part
                totalValue += (value / weight) * capacity;
                break; // Knapsack is full
            }
        }

        System.out.println("Maximum value in knapsack = " + totalValue);
    }
}
-----------------------------------------------------------
import java.util.*;

class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

public class GraphBFS {

    // Function to create the graph
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example: Undirected graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    // BFS function
    static void bfs(ArrayList<Edge>[] graph, int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (Edge e : graph[curr]) {
                if (!visited[e.dest]) {
                    q.add(e.dest);
                    visited[e.dest] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        boolean[] visited = new boolean[V];

        System.out.print("BFS traversal starting from node 0: ");
        bfs(graph, 0, visited);
    }
}
---------------------------------------------------------
import java.util.*;

class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

public class GraphDFS {

    // Function to create the graph
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example: Undirected graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    // DFS function
    static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        // Visit current node
        System.out.print(curr + " ");
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] visited = new boolean[V];

        System.out.print("DFS traversal starting from node 0: ");
        dfs(graph, 0, visited);
    }
}
---------------------------------------
import java.util.*;

public class DFS_Stack {
    static class Edge {
        int src, dest;
        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void dfsStack(ArrayList<Edge>[] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + " ");

                // Push neighbors in reverse to simulate left-to-right traversal
                for (int i = graph[curr].size() - 1; i >= 0; i--) {
                    Edge e = graph[curr].get(i);
                    if (!visited[e.dest]) {
                        stack.push(e.dest);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.print("DFS using stack: ");
        dfsStack(graph, 0);
    }
}
---------------------------------------------------------
import java.util.*;

public class PrimsAlgorithm {
    static class Edge {
        int dest;
        int cost;
        Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }
    }

    static class Pair {
        int node;
        int cost;
        Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges (undirected)
        graph[0].add(new Edge(1, 10));
        graph[0].add(new Edge(2, 15));
        graph[0].add(new Edge(3, 30));

        graph[1].add(new Edge(0, 10));
        graph[1].add(new Edge(3, 40));

        graph[2].add(new Edge(0, 15));
        graph[2].add(new Edge(3, 50));

        graph[3].add(new Edge(0, 30));
        graph[3].add(new Edge(1, 40));
        graph[3].add(new Edge(2, 50));
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.add(new Pair(0, 0)); // Start from node 0

        int totalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!visited[curr.node]) {
                visited[curr.node] = true;
                totalCost += curr.cost;
                System.out.println("Visited: " + curr.node + " via cost: " + curr.cost);

                for (Edge e : graph[curr.node]) {
                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.cost));
                    }
                }
            }
        }

        System.out.println("Minimum Cost of Spanning Tree: " + totalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        prims(graph);
    }
}
-----------------------------------------------------
import java.util.*;

public class SimpleKruskal {

    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void kruskal(int V, ArrayList<Edge> edges) {
        // Sort edges based on their weight
        Collections.sort(edges, (a, b) -> a.weight - b.weight);

        // Array to keep track of visited nodes
        boolean[] visited = new boolean[V];
        int mstWeight = 0;

        // Process each edge in sorted order
        System.out.println("Edges in the MST:");
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;

            // Include the edge if both nodes are not visited yet
            if (!visited[u] || !visited[v]) {
                visited[u] = true;
                visited[v] = true;
                mstWeight += edge.weight;
                System.out.println(u + " - " + v + " with weight: " + edge.weight);
            }
        }

        System.out.println("Minimum Cost of Spanning Tree: " + mstWeight);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();

        // Add edges to the graph
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

        // Call Kruskal's algorithm
        kruskal(V, edges);
    }
}
