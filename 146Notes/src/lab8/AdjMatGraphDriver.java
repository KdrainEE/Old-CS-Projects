package lab8;

public class AdjMatGraphDriver {

	public static void main(String[] args) {
		//make a new graph of size 7
		AdjMatGraph graph = new AdjMatGraph(7);
		//addEdges to the graph
		graph.addEdge(1, 0, 1);
		graph.addEdge(3, 0, 1);
		graph.addEdge(3, 1, 1);
		graph.addEdge(4, 3, 1);
		graph.addEdge(2, 3, 1);
		graph.addEdge(4, 2, 1);
		graph.addEdge(5, 2, 1);
		graph.addEdge(5, 4, 1);
		graph.addEdge(6, 4, 1);
		
		//show that print DFS works
		System.out.println("Printing DFS for Vertex 1");
		graph.printDFS(0);
		//show that print BFS works
		System.out.println("Printing BFS for Vertex 1");
		graph.printBFS(0);
		//show that print DFS for all works
		System.out.println("Printing DFS for all vertices.");
		graph.printDFSForAll();
		//Show that print BFS for all works
		System.out.println("Printing BFS for all vertices.");
		graph.printBFSForAll();

	}

}
