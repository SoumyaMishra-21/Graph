package traversal;
import java.util.*;
public class DFS {

	static class Edge{
		int src;
		int dest;
		public Edge(int s,int d) {
			this.src=s;
			this.dest=d;
		}
	}
	
	public static void create(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<Edge>();
		}
	 
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,3));
		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,4));
		graph[3].add(new Edge(3,1));
		graph[3].add(new Edge(3,4));
		graph[3].add(new Edge(3,5));
		graph[4].add(new Edge(4,2));
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));
		graph[5].add(new Edge(5,3));
		graph[5].add(new Edge(5,4));
		graph[5].add(new Edge(5,6));
		graph[6].add(new Edge(6,5));
	}
	
	public static void bfs(ArrayList<Edge> graph[],int v) {
		Queue<Integer> q = new LinkedList<>();
		boolean vis[] = new boolean[v];
		q.add(0);
		while(!q.isEmpty()) {
			int curr = q.remove();
			if(vis[curr]==false) {
				System.out.println(curr);
				vis[curr]=true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e = graph[curr].get(i);
			q.add(e.dest);
		}
			}
		}
	}
	
	public static void dfs(ArrayList<Edge> graph[],int curr,boolean[] vis) {
		System.out.println(curr);
		vis[curr] = true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e = graph[curr].get(i);
			if(vis[e.dest]==false) {
			dfs(graph,e.dest,vis);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 7;
    ArrayList<Edge> graph[] = new ArrayList[v];
    create(graph);
    bfs(graph,v);
    boolean vis[] = new boolean[v];
    for(int i=0;i<v;i++) {
    	if(vis[i]==false) {
    	    dfs(graph,0,vis);
    	}
    }
	}

}
