import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] graph;
	static boolean[] visited;
	static int result;
	static StringTokenizer st;

	public static boolean is_Okay(boolean[] arr) {
		for (boolean b : arr) {
			if (!b) {
				return true;
			}
		}
		return false;
	}

	public static void dfs(int start, int now, int cnt) {
		if (result < cnt) { // 이미 결과를 넘어버렸으면 더 탐색할필요없다.
			return;
		}
		if (start == now && !is_Okay(visited)) { // 방문한적 없고 시작지점이면
			result = Math.min(result, cnt);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (graph[now][i] == 0 || visited[i]) { // 못가거나, 방문했으면
				continue;
			}
			visited[i] = true;
			dfs(start, i, cnt + graph[now][i]);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visited = new boolean[N];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, 0);
		System.out.println(result);
	}
}