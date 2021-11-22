import java.io.*;
import java.util.*;

class DistanciaGrafos
{
    private int V; 
    private LinkedList<Integer> adj[];

    DistanciaGrafos(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }


    public int distancia(int root, int destination){

        boolean visited[] = new boolean[V];
        int dist[] = new int[V];

        for (int i = 0; i < V; i++) {

            dist[i] = 0;

        }

        Queue<Integer> queue = new LinkedList<Integer>();
        dist[root] = 0;

        queue.add(root);
        visited[root] = true;

        while(!queue.isEmpty()){

            int current = queue.poll();

            Iterator<Integer> i = adj[current].listIterator();
            
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {   
                    // Update distance:
                    dist[n] = dist[current] + 1;

                    visited[n] = true;
                    queue.add(n);
                
                } else {

                    continue;

                }
            }

        }

        return dist[destination];

    }

    void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public static void main(String args[]){
        DistanciaGrafos g = new DistanciaGrafos(28);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(0, 7);
        g.addEdge(7, 10);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(3, 5);
        g.addEdge(4, 8);
        g.addEdge(4, 5);
        g.addEdge(8, 9);
        g.addEdge(8, 10);
        g.addEdge(4, 8);
        g.addEdge(7, 18);
        g.addEdge(9, 12);
        g.addEdge(9, 11);
        g.addEdge(10, 11);
        g.addEdge(10, 14);
        g.addEdge(11, 15);
        g.addEdge(11, 16);
        g.addEdge(12, 13);
        g.addEdge(12, 5);
        g.addEdge(12, 17);
        g.addEdge(13, 6);
        g.addEdge(13, 17);
        g.addEdge(13, 22);
        g.addEdge(22, 6);
        g.addEdge(21, 22);
        g.addEdge(14, 15);
        g.addEdge(14, 18);
        g.addEdge(14, 19);
        g.addEdge(15, 16);
        g.addEdge(15, 20);
        g.addEdge(16, 17);
        g.addEdge(16, 20);
        g.addEdge(17, 13);
        g.addEdge(17, 12);
        g.addEdge(17, 21);
        g.addEdge(18, 24);
        g.addEdge(18, 14);
        g.addEdge(18, 19);
        g.addEdge(19, 14);
        g.addEdge(19, 19);
        g.addEdge(19, 20);
        g.addEdge(19, 25);
        g.addEdge(20, 21);
        g.addEdge(20, 26);
        g.addEdge(20, 23);
        g.addEdge(21, 22);
        g.addEdge(24, 25);
        g.addEdge(25, 19);
        g.addEdge(25, 26);
        g.addEdge(26, 20);
        g.addEdge(26, 27);
        g.addEdge(23, 27);

        System.out.println("Bellas Artes a Jamaica - " + g.distancia(11, 21));
        System.out.println("Tacubaya a Pantitlan - " + g.distancia(18, 22));
        System.out.println("La Raza a Mixcoac - " + g.distancia(4, 24));
        System.out.println("Tacuba a Hidalgo - " + g.distancia(7, 10));
        System.out.println("Guerrero a Garibaldi - " + g.distancia(8, 9));

    }
}