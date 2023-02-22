import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] graph;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void bfs(int x, int y) {

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int new_x = arr[0];
			int new_y = arr[1];

			for (int i = 0; i < 4; i++) {

				int nx = new_x + dx[i];
				int ny = new_y + dy[i];

				if (nx <= -1 || nx >= M || ny <= -1 || ny >= N)
					continue;
				if (graph[nx][ny] == 0) {

					q.add(new int[] { nx, ny });
					graph[nx][ny] = graph[new_x][new_y] + 1;
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[M][N];
		int start_x = 0;
		int start_y = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				graph[i][j] = k;
				if (k == 1) {
					q.add(new int[] { i, j });
					if (q.isEmpty()) {
						start_x = i;
						start_y = j;
					}
				}
			}
		}

		bfs(start_x, start_y);
		boolean flag = true;
		int max_num = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 0) {
					flag = false;
				}
				if (graph[i][j] > max_num) {
					max_num = graph[i][j];
				}
			}
		}
		
		if (flag==false) {
			System.out.println(-1);
		}
		else {
			System.out.println(max_num-1);
		}
	}
}