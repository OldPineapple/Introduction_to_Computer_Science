package assignment4Graph;
//Name: Hanwen Wang   ID:260778557
public class Graph {
	
	boolean[][] adjacency;
	int nbNodes;
	
	public Graph (int nb){
		this.nbNodes = nb;
		this.adjacency = new boolean [nb][nb];
		for (int i = 0; i < nb; i++){
			for (int j = 0; j < nb; j++){
				this.adjacency[i][j] = false;
			}
		}
	}
	
	public void addEdge (int i, int j){
		// ADD YOUR CODE HERE
		if(i<=this.nbNodes&&j<=this.nbNodes&&i>=0&&j>=0)
		this.adjacency[i][j]=true;
		this.adjacency[j][i]=true;
	}
	
	public void removeEdge (int i, int j){
		// ADD YOUR CODE HERE
		if(this.adjacency[i][j]==true)
		{
			this.adjacency[i][j]=false;
			this.adjacency[j][i]=false;
		}
		else;
	}
	
	public int nbEdges(){
		// ADD YOUR CODE HERE
		int nb=0;
		for (int i = 0; i < this.nbNodes; i++){
			for (int j = 0; j < this.nbNodes; j++){
				if(this.adjacency[i][j]==true)
				{
					nb++;
				}
			}
		}
		return nb/2; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public boolean cycle(int start){
		boolean []visited=new boolean[this.nbNodes];
		for (int i = 0; i < this.nbNodes; i++){
				visited[i]=false;
		}
		
		// ADD YOUR CODE HERE
		return dfs(start,start,visited);
	}
	
	public int shortestPath(int start, int end){
		int length=0;
		boolean visited[]=new boolean [this.nbNodes];
		for(int i=0;i<this.nbNodes;i++)
		{
			visited[i]=false;
		}
		int queue[]=new int[this.nbNodes];
		for(int j=0;j<this.nbNodes;j++)
		{
			queue[j]=-1;
		}
		visited[start]=true;
		this.enqueue(queue, start);
		while(!this.isEmpty(queue))
		{
			int num=this.dequeue(queue);
			for(int k=0;k<this.nbNodes;k++)
			{
				if(this.adjacency[k][num]==true&&visited[k]==false)
				{
					if(k==end)
					{
						length++;
						return length;
					}
					visited[k]=true;
					this.enqueue(queue, k);
				}
			}
			length++;
		}
		// ADD YOUR CODE HERE
		return this.nbNodes+1; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	private void enqueue(int queue[],int point)
	{
		for(int i=0;i<queue.length;i++)
		{
			if(queue[i]==-1)
			{
				queue[i]=point;
				return;
			}
		}
	}
	private int dequeue(int queue[])
	{
		for(int i=0;i<queue.length;i++)
		{
			if(queue[i]!=-1)
			{
				int deq=queue[i];
				queue[i]=-1;
				return deq;
			}
		}
		return -1;
	}
	private boolean isEmpty(int queue[])
	{
		for(int i=0;i<queue.length;i++)
		{
			if(queue[i]!=-1)
			{
				return false;
			}
		}
		return true;
	}
	
 	private boolean dfs(int start,int num,boolean visited[])
	{
		visited[start]=true;
		for(int i=0;i<this.nbNodes;i++)
		{
			if(this.adjacency[i][start]==true)
			{
				if (visited[i]==false)
				{
					dfs(i,start,visited);
				}
				else
				{
					if(i!=num)
						return true;
				}
			}
		}
		return false;
	}
}
