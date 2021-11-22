import java.io.*;
import java.util.*;

class Graph
{
	private int V;
    public int distances[];
    private HashSet<Integer> measured;
	private List<List<Node>> adj; 
    private PriorityQueue<Node> prq;

	public Graph(int v)
	{
		V = v;
        distances = new int[v];
        measured = new HashSet<Integer>();
        prq = new PriorityQueue<Node>(V, new Node());

        adj = new ArrayList<List<Node>>();

		for (int i = 0; i < V; i++) {
            List<Node> n = new ArrayList<Node>();
            adj.add(n);
        }

	}

    
    private void measure(int n) {

        int edgeDistance = -1;
        int measuredDistance = -1;

        for(int i = 0; i < adj.get(n).size(); i++){

            Node current = adj.get(n).get(i);

            if(!measured.contains(current.node)){
                edgeDistance = current.cost;
                measuredDistance = edgeDistance + distances[n];

                if(distances[current.node] > measuredDistance){
                    distances[current.node] = measuredDistance;
                }
                prq.add(new Node(current.node, distances[current.node]));
            }
        }
    }

    public void dijkstra(int root){

        for (int i = 0; i < V; i++){
            distances[i] = Integer.MAX_VALUE;
        }

        prq.add(new Node(root, 0));
        distances[root] = 0;

        while(measured.size() != V) {
            if(prq.isEmpty()){
                return;
            }
            int current = prq.poll().node;
            if(measured.contains(current)){
                continue;
            }
            measured.add(current);
            measureNeighbours(current);
        }

    }

	public void addEdge(int v,int w, int cost)
	{
		adj.get(v).add(new Node(w, cost));
        adj.get(w).add(new Node(v, cost));
	}

	public static void main(String args[])
	{
		Graph g = new Graph(28);
		g.addEdge(0, 1, 5);
		g.addEdge(1, 2, 1);
        g.addEdge(1, 4, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(0, 7, 3);
		g.addEdge(7, 10, 6);
		g.addEdge(2, 4, 1);
        g.addEdge(4, 5, 2);
        g.addEdge(5, 6, 2);
        g.addEdge(3, 5, 2);
        g.addEdge(4, 8, 1);
        g.addEdge(4, 5, 2);
        g.addEdge(8, 9, 0);
        g.addEdge(8, 10, 0);
        g.addEdge(4, 8, 1);
        g.addEdge(7, 18, 4);
        g.addEdge(9, 12, 2);
        g.addEdge(9, 11, 0);
        g.addEdge(10, 11, 0);
        g.addEdge(10, 14, 1);
        g.addEdge(11, 15, 1);
        g.addEdge(11, 16, 2);
        g.addEdge(12, 13, 0);
        g.addEdge(12, 5, 1);
        g.addEdge(12, 17, 0);
        g.addEdge(13, 6, 2);
        g.addEdge(13, 17, 0);
        g.addEdge(13, 22, 5);
        g.addEdge(22, 6, 2);
        g.addEdge(21, 22, 4);
        g.addEdge(14, 15, 0);
        g.addEdge(14, 18, 5);
        g.addEdge(14, 19, 2);
        g.addEdge(15, 16, 1);
        g.addEdge(15, 20, 2);
        g.addEdge(16, 17, 1);
        g.addEdge(16, 20, 1);
        g.addEdge(17, 13, 0);
        g.addEdge(17, 12, 0);
        g.addEdge(17, 21, 1);
        g.addEdge(18, 24, 2);
        g.addEdge(18, 14, 5);
        g.addEdge(18, 19, 2);
        g.addEdge(19, 14, 2);
        g.addEdge(19, 20, 1);
        g.addEdge(19, 25, 3);
        g.addEdge(20, 21, 0);
        g.addEdge(20, 26, 5);
        g.addEdge(20, 23, 1);
        g.addEdge(21, 22, 4);
        g.addEdge(24, 25, 2);
        g.addEdge(25, 19, 3);
        g.addEdge(25, 26, 2);
        g.addEdge(26, 20, 5);
        g.addEdge(26, 27, 1);
        g.addEdge(23, 27, 5);

        int root = 0;

		g.dijkstra(root);
        System.out.println("The shorted:");
  
        for (int i = 0; i < g.distances.length; i++){
            System.out.println(root + " to " + i + " is " + g.distances[i]);
        }
	}
}