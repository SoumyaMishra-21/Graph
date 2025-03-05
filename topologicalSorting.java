package topo;
import java.util.*;
public class topologicalSorting {

     static class Edge{
    	 int src;
    	 int dest;
    	 public Edge(int s,int d) {
    		 this.src = s;
    		 this.dest = d;
    	 }
     }
     
     public static void create(ArrayList<Edge> graph[],int v) {
    	 for(int i=0;i<v;i++) {
    		 graph[i] = new ArrayList<>();
    	 }
    	 
    	 graph[5].add(new Edge(5,0));
    	 graph[4].add(new Edge(4,0));
    	 graph[5].add(new Edge(5,2));
    	 graph[2].add(new Edge(2,3));
    	 graph[3].add(new Edge(3,1));
    	 graph[4].add(new Edge(4,1));
      }
     
     public static void toposort(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer> Stack) {
    	 vis[curr] = true;
    	 for(int i=0;i<graph[curr].size();i++) {
    		 Edge e = graph[curr].get(i);
    		 if(!vis[e.dest]) {
    			 toposort(graph,e.dest,vis,Stack);
    		 }
    	 }
    	 Stack.push(curr);
     }
     
     public static void topoSorting(ArrayList<Integer> graph[],int v) {
    	 boolean vis[] = new boolean[v];
     }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int v = 6;
       ArrayList<Edge> graph[] = new ArrayList[6];
       create(graph,v);
       
	}

}
