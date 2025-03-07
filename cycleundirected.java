package cycle;
import java.util.*;
public class cycleundirected {

	static class edg{
		int src;
		int dest;
		public edg(int s,int d) {
			this.src = s;
			this.dest = d;
		}
	}
	
	public static void create(ArrayList<edg> graph[],int v) {
		for(int i=0;i<v;i++) {
			graph[i] = new ArrayList<edg>();
		}
		graph[0].add(new edg(0,1));
		graph[0].add(new edg(0,4));
		graph[1].add(new edg(1,0));
		graph[1].add(new edg(1,2));
		graph[1].add(new edg(1,4));
		graph[2].add(new edg(2,1));
		graph[2].add(new edg(2,3));
		graph[3].add(new edg(3,2));
		graph[4].add(new edg(4,0));
		graph[4].add(new edg(4,1));
		graph[4].add(new edg(4,5));
		graph[5].add(new edg(5,4));
	}
	
	public static boolean cycle(ArrayList<edg> graph[],boolean vis[],int curr,int par) {
		vis[curr] = true;
		for(int i=0;i<graph[curr].size();i++) {
			edg e = graph[curr].get(i);
			if(vis[e.dest]==true && par!=e.dest) {
				return true;
			}else if(!vis[e.dest]) {
				if(cycle(graph,vis,e.dest,curr)==true) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 6;
     ArrayList<edg> graph[] = new ArrayList[v];
     create(graph,v);
     boolean vis[] = new boolean[v];
     System.out.println(cycle(graph,vis,0,0));
	}

}
