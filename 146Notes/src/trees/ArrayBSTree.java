package trees;

public class ArrayBSTree<T extends Comparable> {
	
	T[] tree;
	private static final int MAX_SIZE = 100;
	
	public ArrayBSTree()
	{
		tree = (T[])new Comparable[MAX_SIZE];
	}
	public ArrayBSTree(int size)
	{
		if (size <= 0)
			return;
		tree = (T[])new Comparable[size];
	}
	
	public void insert(T data)
	{
		if (tree[0] == null)//root is null
			tree[0] = data;
		else//recursive insert
			insert(0,data);
	}
	private void insert(int index, T data)
	{
		if (tree[index] == null)//found leaf
			tree[index] = data;
		else if (data.compareTo(tree[index])<0)//GO LEFT
		{
			if (index*2+1<tree.length)
				insert(index*2+1, data);
			else
				System.out.println("Cannot insert into tree.");
		}
		else if (data.compareTo(tree[index])>=0)//GO RIGHT
		{
			if (index*2+2 < tree.length)
				insert(index*2+2, data);
			else
				System.out.println("Cannot insert into tree");
		}
	}
	
	public void printBreadthOrder()
	{
		for (int i=0; i<tree.length;i++)
		{
			if (tree[i] != null)
				System.out.println(tree[i]);
		}
	}
	
	public void delete(T value)
	{
		delete(0,value);
	}
	private void delete(int index, T value)
	{
		//find the value 
		if(index >= tree.length || tree[index] == null)//didn't find value
			return;
		if(value.compareTo(tree[index]) < 0)//go left
		{
			if(index*2+1 < tree.length)
				delete(index*2+1, value);
		}
		else if(value.compareTo(tree[index])>0)//go right
		{
			if(index*2+2 < tree.length)
				delete(index*2+2,value);
		}
		else //found it
		{
			// has no children or at least 1 and it is the left one
			if(index*2+1<tree.length &&
					index*2+2 < tree.length &&
						tree[index*2+2] == null)
			{
				//move entire left subtree
				moveLeftSubtree(index);
				return;
			}
			//has a left child
			if(index*2+2 < tree.length && tree[index*2+2]==null)
			{
				//TODO move the entire right subtree
				return;
			}
			//has two children
			//TODO find the min in right subtree and replace current index
			
			//TODO delete the smallest from the right subtree
			
				
		}
	}
	private void moveLeftSubtree(int index)
	{
		if(index<=tree.length)
			return;
		boolean isLeft = index%2 == 1;
		if(isLeft || index == 0)
		{
			if (index*2+1<tree.length)
			{
				tree[index] = tree[index*2+1];
			}
			else
			{
				tree[index] = null;
				return;
			}
		}
		else
		{
			if((index-1)*2+2 < tree.length)
			{
				tree[index] = tree[(index-1)*2+2];
			}
			else
			{
				tree[index] = null;
				return;
			}
		}
		moveLeftSubtree(index*2+1);
		moveLeftSubtree(index*2+2);
	}
}




























