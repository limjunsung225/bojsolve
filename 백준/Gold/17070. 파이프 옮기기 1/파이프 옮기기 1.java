import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static boolean is_Okay(int x, int y) { // 맵 밖으로 나가는지
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static int N, res;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move(0, 1, 0);
		// dir -> 0 : 가로, 1 : 세로, 2 : 대각선

		System.out.println(res);
	}

	public static void move(int x, int y, int dir) {

		if (x == N - 1 && y == N - 1 && graph[x][y] != 1) {
			res++;
			return;
		}
		// 가로로
		if (dir == 0) {
			// 가로 -> 오른쪽
			if (is_Okay(x, y + 1) && graph[x][y + 1] == 0) {
				move(x, y + 1, 0);
			}
			// 가로 -> 오른쪽아래
			if (is_Okay(x + 1, y + 1) && graph[x + 1][y + 1] == 0 && graph[x + 1][y] == 0 && graph[x][y + 1] == 0) {
				move(x + 1, y + 1, 2);
			}
		} 
		else if (dir == 1) { // 세로
			// 세로 -> 아래
			if (is_Okay(x + 1, y) && graph[x + 1][y] == 0) {
				move(x + 1, y, 1);
			}
			// 세로 -> 오른아래
			if (is_Okay(x + 1, y + 1) && graph[x + 1][y + 1] == 0 && graph[x][y + 1] == 0 && graph[x + 1][y] == 0) {
				move(x + 1, y + 1, 2);
			}

		} else if (dir == 2) { // 대각
			// 대각 -> 가로
			if (is_Okay(x, y + 1) && graph[x][y + 1] == 0) {
				move(x, y + 1, 0);
			}

			// 대각 -> 세로
			if (is_Okay(x + 1, y) && graph[x + 1][y] == 0) {
				move(x + 1, y, 1);
			}

			// 대각 -> 대각
			if (is_Okay(x + 1, y + 1) && graph[x + 1][y + 1] == 0 && graph[x][y + 1] == 0 && graph[x + 1][y] == 0) {
				move(x + 1, y + 1, 2);
			}
		}
	}
}