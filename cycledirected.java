package cycle;
import java.util.*;
public class cycledirected {

	static class Edge{
		int src;
		int dest;
		public Edge(int s,int d) {
			this.src=s;
			this.dest=d;
		}
	}
	
	public static void create(ArrayList<Edge> graph[],int v) {
		for(int i=0;i<graph.length;i++) {
			graph[i]=new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(0,2));
		graph[0].add(new Edge(0,1));
		graph[2].add(new Edge(2,3));
		graph[1].add(new Edge(1,3));
	}
	
	public static boolean isCycle(ArrayList<Edge> graph[],boolean vis[],boolean rec[],int curr) {
		vis[curr] = true;
		rec[curr] = true;
		for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
           if(rec[e.dest]==true) {   
        	   return true;
           }else if(!vis[e.dest]) {
        	   if(isCycle(graph,vis,rec,e.dest)){
        		   return true;
        	   }
           }
    		
		}   
		 rec[curr]=false;  
         return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v=4;
     ArrayList<Edge> graph[] = new ArrayList[v];
     create(graph,v);
     boolean vis[] = new boolean[v];
     boolean rec[] = new boolean[v];
     System.out.println(isCycle(graph,vis,rec,0));
	}

}
