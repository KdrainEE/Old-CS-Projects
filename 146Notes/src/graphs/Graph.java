package graphs;

import java.util.*;

public class Graph {
	//graph elements
	private class Vertex
	{
		String name;
		ArrayList<Edge> neighbors;//pointers to vertices connected to this vertex
		public Vertex(String aName)
		{
			this.name = aName;
			this.neighbors = new ArrayList<Edge>();
		}
	}
	private class Edge
	{
		Vertex toVertex;
		double weight;
		public Edge(Vertex aVertex, double aWeight)
		{
			this.toVertex = aVertex;
			this.weight = aWeight;
		}
	}
	
	Vertex origin;
	ArrayList<Vertex> vertices;
	ArrayList<Vertex> markedVerts;
	ArrayList<Vertex> visitedVerts;
	public Graph()
	{
		origin = null;
		vertices = new ArrayList<Vertex>();
		markedVerts = new ArrayList<Vertex>();
		visitedVerts = new ArrayList<Vertex>();
	}
	public void addVertex(String aName)
	{
		//make sure name is unique
		if(containsName(aName))
			return;
		Vertex v = new Vertex(aName);
		vertices.add(v);
		if(origin == null)
			origin = v;
		
	}
	private boolean containsName(String aName)
	{
		for (Vertex vert : vertices)
		{
			if(vert.name.equals(aName))
				return true;
		}
		return false;
	}
	public void addEdge(String fromVert, String toVert, double weight)
	{
		//find fromVert
		Vertex v1 = getVertex(fromVert);
		//find toVert
		Vertex v2 = getVertex(toVert);
		//make the edge
		if(v1 == null || v2 == null)
			return;
		v1.neighbors.add(new Edge(v2,weight));
	}
	private Vertex getVertex(String aName)
	{
		for(Vertex vert : vertices)
		{
			if (vert.name.equals(aName))
				return vert;
		}
		return null;
	}
	//Depth first search
	public void printDFS()
	{
		markedVerts.clear();
		printDFS(origin);
	}
	private void printDFS(Vertex aVert)
	{
		if (markedVerts.contains(aVert))
			return;
		System.out.println(aVert.name);
		markedVerts.add(aVert);
		for (Edge edge : aVert.neighbors)
		{
			printDFS(edge.toVertex);
		}
	}
	public void printBFS()
	{
		markedVerts.clear();
		visitedVerts.clear();
		System.out.println(origin.name);
		//recursive BFS
		printBFS(origin);
	}
	private void printBFS(Vertex vert)
	{
		if(markedVerts.contains(vert))
			return;
		markedVerts.add(vert);
		for(Edge edge : vert.neighbors)
		{
			if(visitedVerts.contains(vert) || markedVerts.contains(vert))
				continue;
			System.out.println(edge.toVertex.name);
			visitedVerts.add(edge.toVertex);
		}
		for(Edge edge : vert.neighbors)
		{
			printBFS(edge.toVertex);
		}
	}
}
























