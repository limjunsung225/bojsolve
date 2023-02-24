import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int result1, result2, N, flag;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, 1, -1, 0 };
	static char[][] graph;
	static boolean[][] visited;

	public static void dfs_Normal(int x, int y) {

		switch (graph[x][y]) {
		case 'R':
			flag = 1;
			break;
		case 'G':
			flag = 2;
			break;
		case 'B':
			flag = 3;
			break;
		}

		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx <= -1 || nx >= N || ny <= -1 || ny >= N)
				continue;

			if (graph[nx][ny] == 'R' && !visited[nx][ny] && flag == 1) {
				dfs_Normal(nx, ny);
			}

			if (graph[nx][ny] == 'G' && !visited[nx][ny] && flag == 2) {
				dfs_Normal(nx, ny);
			}

			if (graph[nx][ny] == 'B' && !visited[nx][ny] && flag == 3) {
				dfs_Normal(nx, ny);
			}
		}
	}

	public static void dfs_Glory(int x, int y) {

		if(graph[x][y]=='R' || graph[x][y]=='G')flag=1;
		else flag = 3;
		
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx <= -1 || nx >= N || ny <= -1 || ny >= N)
				continue;

			if ((graph[nx][ny] == 'R' || graph[nx][ny] == 'G') && !visited[nx][ny] && flag == 1) {
				dfs_Glory(nx, ny);
			}
		
			if (graph[nx][ny] == 'B' && !visited[nx][ny] && flag == 3) {
				dfs_Glory(nx, ny);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		graph = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String k = st.nextToken();
			for (int j = 0; j < N; j++) {
				graph[i][j] = k.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs_Normal(i, j);
					++result1;
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs_Glory(i, j);
					++result2;
				}
			}
		}
		System.out.printf("%d %d", result1, result2);
	}
}
