import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C, result;
	static Character[][] graph;
	static boolean[][] v;

	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	public static boolean dfs(int x, int y) {
		if (y == C - 1) {
			++result;
			return true;
		}
		v[x][y] = true;

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx <= -1 || nx >= R || ny <= -1 || ny >= C || graph[nx][ny] == 'x')
				continue;
			if (nx >= 0 && nx < R && ny >= 0 && ny < C && !v[nx][ny]) {
				if (dfs(nx, ny))
					return true;

			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new Character[R][C];
		v = new boolean[R][C];
		result = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String k = st.nextToken();
			for (int j = 0; j < C; j++) {
				graph[i][j] = k.charAt(j);

			}
		}
		for (int i = 0; i < R; i++) {
			dfs(i, 0);
		}
		System.out.println(result);
	}
}