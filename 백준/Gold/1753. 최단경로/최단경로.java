import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	public int vex;
	public int cost;

	public Edge(int vex, int cost) {
		this.vex = vex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Main {

	static int V, E, start;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());

		PriorityQueue<Edge>[] graph = new PriorityQueue[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new PriorityQueue<Edge>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Edge(to, weight));
		}
		
		int[] distance = new int [V+1]; // 거리를 표시
		Arrays.fill(distance, -1);
		distance[start] = 0; // 시작점 = 0
		
		while(!graph[start].isEmpty()) {
			Edge temp = graph[start].poll();
			int vex = temp.vex;
			int cost = temp.cost;
			
			if(distance[vex] != -1)continue; // 방문처리된곳은 pass
			distance[vex] = cost; // 저장
			for( Edge edge : graph[vex]) {
				graph[start].add(new Edge(edge.vex, edge.cost+cost));
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(distance[i]==-1) {
				System.out.println("INF");
			}
			else {
				System.out.println(distance[i]);
			}
		}
	}
}
