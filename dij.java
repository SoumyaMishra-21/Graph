package dijkstraa;
import java.util.*;

public class dij {
	static class Edge{
		int src;
		int dest;
		int wt;
		public Edge(int s,int d,int w) {
			this.src=s;
			this.dest=d;
			this.wt = w;
		}
	}
	
	public static class Pair implements Comparable<Pair>{
		int node;
		int dist;
		public Pair(int n,int d) {
			this.node = n;
			this.dist = d;
		}
		public int compareTo(Pair P2) {
			return this.dist-P2.dist;
		}
	}
	
	public static void create(ArrayList<Edge> graph[],int v) {
		for(int i=0;i<graph.length;i++) {
			graph[i]=new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(0,2,4));
		graph[0].add(new Edge(0,1,2));
		graph[2].add(new Edge(2,4,3));
		graph[1].add(new Edge(1,2,1));
		graph[1].add(new Edge(1,3,7));
		graph[3].add(new Edge(3,5,1));
		graph[4].add(new Edge(4,3,2));
		graph[4].add(new Edge(4,5,5));
	}
	
	public static void dijkstra(ArrayList<Edge> graph[],int src) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int v =6;
		int dist[] = new int[v];
		boolean vis[] = new boolean[v];
		for(int i=0;i<v;i++) {
			if(i!=src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}pq.add(new Pair(0,0));
		while(!pq.isEmpty()) {
			Pair curr = pq.remove();
			if(!vis[curr.node]) {
				vis[curr.node] = true;
				for(int i=0;i<graph[curr.node].size();i++) {
					Edge e = graph[curr.node].get(i);
					int u = e.src;
					int d = e.dest;
					if(dist[u]+e.wt < dist[d]) {
						dist[d] = dist[u]+e.wt;
						pq.add(new Pair(d,dist[d]));
					}
				}
			}
		}
		for(int i=0;i<v;i++) {
			System.out.println(dist[i]);
		}
	}
	
	public static void main(String[] args) {
		int v =6;
		ArrayList<Edge> graph[] = new ArrayList[v];
		create(graph,v);
		dijkstra(graph,0);
	}
}
