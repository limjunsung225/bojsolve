import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int graph[][];
	static boolean visited[];
	static int N;
	static int M;
	static int V;
	static StringBuilder sb;

	public static void dfs(int v) {

		visited[v] = true;
		sb.append(v);
		sb.append(" ");

		for (int i = 1; i <= N; i++) {
			if (graph[v][i]==1 && !visited[i])
				dfs(i);
		}

	}
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		visited[v] = true;
		
		while (!q.isEmpty()) {
			v = q.poll();
			sb.append(v);
			sb.append(" ");
			for(int i=1; i<=N;i++) {
				if(graph[v][i]==1 && !visited[i]) {
					q.add(i);
					visited[i]=true;
				}
			}
		}
	}
	

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = bf.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		V = Integer.parseInt(str[2]);
		graph = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			String[] str2 = bf.readLine().split(" ");
			int a = Integer.parseInt(str2[0]);
			int b = Integer.parseInt(str2[1]);

			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		sb = new StringBuilder();
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println(sb);
		
		sb = new StringBuilder();
		visited = new boolean[N + 1];
		bfs(V);
		System.out.println(sb);

	}
}