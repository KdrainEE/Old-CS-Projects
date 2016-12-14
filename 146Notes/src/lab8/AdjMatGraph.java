package lab8;

import java.util.*;

public class AdjMatGraph {
	//class variables
	private static final int DEFAULT_VERTEX_COUNT = 10;
	private double[][] adjMatrix;
	private ArrayList<Integer> markedVerts;
	private ArrayList<Integer> visitedVerts;
	
	//constructors
	public AdjMatGraph()
	{
		adjMatrix = new double[DEFAULT_VERTEX_COUNT][DEFAULT_VERTEX_COUNT];
		//initialize graph
		initGraph();
		
	}
	public AdjMatGraph(int size)
	{
		if(size>1)
			adjMatrix = new double[size][size];
		//initialize graph
		initGraph();
	}
	private void initGraph()
	{
		for(int i=0;i<adjMatrix.length;i++)
		{
			for(int j=0;j<adjMatrix[i].length;j++)
			{
				adjMatrix[i][j] = 0;
			}
		}
		markedVerts = new ArrayList<Integer>();
		visitedVerts = new ArrayList<Integer>();
	}
	//add an edge to the adjacency matrix
	public void addEdge(int toVert, int fromVert, double weight)
	{
		if(isValidVert(toVert)== false || isValidVert(fromVert)==false  || weight <0.0)
			return;
		adjMatrix[fromVert][toVert] = weight;
	}
	private boolean isValidVert(int vert)//check if the vertex will be in the bounds of the matrix
	{
		return vert>=0 && vert < adjMatrix.length;
	}
	//depth first search for a given index
	public void printDFS(int startVert)
	{
		//clear marked vertices list
		markedVerts.clear();
		//recursive call
		printDFS1(startVert);
	}
	//recursive helper method
	private void printDFS1(int index)
	{
		//print the vertex then add it to the visited list
		System.out.println("Vertex "+(index+1));
		markedVerts.add(index);
		//go deeper
		for(int i=0; i<adjMatrix[index].length; i++)
		{
			//if a neighbor is not in the marked vertices list, make the recursive call
			if(adjMatrix[index][i] != 0 && markedVerts.contains(i) == false)
				printDFS1(i);
		}
	}
	//breadth first search for a given index
	public void printBFS(int startVert)
	{
		//clear the marked and visited lists
		markedVerts.clear();
		visitedVerts.clear();
		//print out the starting value
		System.out.println("Vertex "+(startVert+1));
		//recursive call
		printBFS1(startVert);
	}
	//recursive helper method
	private void printBFS1(int index)
	{
		//return if this vertex has been marked
		if(markedVerts.contains(index))
			return;
		//otherwise add it to the list of marked vertices
		markedVerts.add(index);
		//visit all the neighbors
		for(int i=0; i< adjMatrix[index].length; i++)
		{
			if(adjMatrix[index][i] != 0)
			{
				//if that neighbor has already been visited or marked then go on to the next neighbor
				if(visitedVerts.contains(i) || markedVerts.contains(i))
					continue;
				//if not, print it out and add to the list of visited vertices
				System.out.println("Vertex "+(i+1));
				visitedVerts.add(i);
			}
		}
		//now that we visited all of the neighbors we can go deeper
		for(int i=0; i<adjMatrix[index].length;i++)
		{
			//call DFS on any neighbor that has not been marked
			if (adjMatrix[index][i] != 0 && !markedVerts.contains(i))
				printBFS1(i);
		}
	}
	//prints the depth first search for each value in the graph
	public void printDFSForAll()
	{
		for(int i=0; i<adjMatrix.length;i++)
		{
			printDFS(i);
		}
	}
	//prints the breadth first search for each vertex in the graph
	public void printBFSForAll()
	{
		for(int i=0; i<adjMatrix.length;i++)
		{
			printBFS(i);
		}
	}
}













