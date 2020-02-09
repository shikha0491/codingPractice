/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Graph
{
	int [][] adjmatrix;
	ArrayList<GraphNode> nodeList = new ArrayList<>();
	 
	
	
	public Graph (ArrayList<GraphNode> nodeList) {
	    this.nodeList = nodeList;
	    adjmatrix = new int[nodeList.size()][nodeList.size()];
	    
	}
	
	
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i-1);
		GraphNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);//Neighbour of first is second. Store it.
		second.getNeighbors().add(first);//Neighbour of second is first. Store it.
	}
	
	public void addDirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i-1);
		GraphNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);//Neighbour of first is second. Store it.
	//	second.getNeighbors().add(first);//Neighbour of second is first. Store it.
	}
	
	public addValueInMatrixDirectedGraph (int i, int j) {
	    i--;
	    j--;
	    adjmatrix[i][j] = 1;
	    
	}
	
	public addValueInMatrixUnDirectedGraph (int i, int j) {
	    i--;
	    j--;
	    adjmatrix[i][j] = 1;
	    adjmatrix[i][j] = 1;
	    
	}
	
	public bfsSearch () {
	    
	    for(GraphNode node: nodeList) { //if a node is unvisited then run bfs on it
			if(!node.isVisited())
				
				LinkedList<GraphNode>queue = new LinkedList<>();
				queue.add(node);
				while (!queue.isEmpty) {
				    
				    GraphNode presentNode = queue.remove(0);
				    presentNode.setVisited(true);
				    System.out.println(presentNode.getName());
				    List<GraphNode> neighbors = getNeighbors(node);
				    for(GraphNode neighbor: neighbors) { 	//for each neighbor of present node
				        if(!neighbor.isVisited()) {
				    	queue.add(neighbor);
					    neighbor.setVisited(true);
				    }
			    }
				    
				}
				
		}
	    
	}
	
	public dfsRec () {
	    for (GraphNode node : nodeList) {
	        if (!node.isVisited) {
	            dfsRecursive(node);
	        }
	    }
	}
	
	public dfsRecursive (GraphNode node) {
	    
	    node.setVisited(true);
	    System.out.println (node.getName());
	    for (GraphNode graphNode : node.getNeighbors()) {
	        
	        if (!graphNode.isVisited()) {
	            dfsRecursive(node);
	        }
	    }
	    
	}
	
	
	public dfs () {
	   
	    for (GraphNode node : nodeList ) {
	        List<GraphNode> stack = new ArrayList<>();
	        if (!node.isVisited) {
	            stack.add(0,node) ;
	            stack.setVisited(true);
	            while (!stack.isEmpty()) {
	                // Pop
	                GraphNode presentNode = stack.remove(0);
	                System.out.println(presentNode.getName());
	                List<GraphNode> neighbors = presentNode.getNeighbors;
	                for (GraphNode node : neighbors) {
	                    if (!node.isVisited) {
	                        stack.add(0,node );
	                        node.setVisited(true);
	                    }
	                }
	            }
	            
	        }     
	    }
	}
	
	
	
	
	public  ArrayList<GraphNode> getNeighbors(GraphNode node) {
		ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
		
		//gets row# to search in node index
		int nodeIndex = node.getIndex();
	
		for(int i=0; i<adjacencyMatrix.length;i++) {
			//if a column has 1 in that row then there is a neighbor and add it to list
			if(adjacencyMatrix[nodeIndex][i]==1) {
				neighbors.add(nodeList.get(i));
			}
		}
		return neighbors;
	}
	
	
	
	
}

class GraphNode {
    
    private String name;
	private int index; //index is used to map this Node's name with index of Adjacency Matrix' cell#
	private ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
	private boolean isVisited = false;
	private GraphNode parent;
	private HashMap<GraphNode, Integer> weightMap = new HashMap<>();
	private int distance;
	
	
	
	public GraphNode(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<GraphNode> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<GraphNode> neighbors) {
		this.neighbors = neighbors;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public GraphNode getParent() {
		return parent;
	}

	public void setParent(GraphNode parent) {
		this.parent = parent;
	}

	public GraphNode(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  name ;
	}


    
}


