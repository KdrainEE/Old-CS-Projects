package graphs;

import java.util.*;

public class AdjMatGraph {
	private static final int DEFAULT_VERTEX_COUNT = 10;
	private double[][] adjMatrix;
	private ArrayList<Integer> markedVerts;
	
	public AdjMatGraph()
	{
		adjMatrix = new double[DEFAULT_VERTEX_COUNT][DEFAULT_VERTEX_COUNT];
		initGraph();
	}
	public AdjMatGraph(int size)
	{
		if(size > 1)
			adjMatrix = new double[size][size];
		initGraph();
	}
	private void initGraph()
	{
		for(int i=0; i<adjMatrix.length;i++)
		{
			for(int j=0; j<adjMatrix[i].length; j++)
				adjMatrix[i][j] = 0;
		}
		markedVerts = new ArrayList<Integer>();
	}
	public void addEdge(int toVert, int fromVert, double weight)
	{
		if(isValidVert(toVert) == false || isValidVert(fromVert) == false
				||weight < 0.0)
			return;
		adjMatrix[toVert][fromVert] = weight;
	}
	private boolean isValidVert(int vert)
	{
		return vert >=0 && vert < adjMatrix.length;
	}
	public void printDFS()
	{
		markedVerts.clear();
		printDFS(0);
		
	}
	private void printDFS(int index)
	{
		System.out.println("Vertex "+index);
		markedVerts.add(index);
		
		for(int i=0; i<adjMatrix[index].length; i++)
		{
			if(adjMatrix[index][i] != 0 && markedVerts.contains(i) == false)
				printDFS(i);
		}
	}
}















