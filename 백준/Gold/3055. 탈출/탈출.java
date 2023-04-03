import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, cnt;
	static int[][] graph;
	static boolean[][] visited;
	static int x_pos, y_pos = 0;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static Queue<int[]> waterq;

	public static void water() { // 물이 움직임
		
		while (cnt != 0) { // 물의 개수만큼 
			int[] waterarray = waterq.poll();
			int x = waterarray[0];
			int y = waterarray[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx <= -1 || nx >= R || ny <= -1 || ny >= C || graph[nx][ny] != 0 || visited[nx][ny]) // 물이 퍼질 수 있으면 
					continue;
				graph[nx][ny] = -2; // 물이 퍼진다.
				visited[nx][ny] = true;
				waterq.add(new int[] {nx,ny});
			}
			cnt -= 1;
		}
	}

	public static boolean isOkay(int x, int y) { // 맵 밖을 나가지 않고, 돌이나 물이 아니면 갈 수 있다.
		if (x <= -1 || x >= R || y <= -1 || y >= C || visited[x][y]) {
			return false;
		}
		if (graph[x][y] == -1 || graph[x][y] == -2) {
			return false;
		}
		return true;
	}

	public static void bfs() {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x_pos, y_pos });

		while (!q.isEmpty()) {

			cnt = waterq.size();
			water(); // 물부터 퍼진다. 
			
			int qsize = q.size();
			for (int size = 0; size < qsize; size++) {  // q의 사이즈 크기만큼 고슴도치가 움직인다.

				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (isOkay(nx, ny)) {

						if (graph[nx][ny] == -4) {
							System.out.println(graph[x][y]);
							System.exit(0);
						}

						graph[nx][ny] = graph[x][y] + 1;
						visited[nx][ny] = true;
						q.add(new int[] { nx, ny });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new int[R][C];
		visited = new boolean[R][C];
		waterq = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String k = st.nextToken();
			for (int j = 0; j < C; j++) {
				char a = k.charAt(j);
				if (a == '.') { // 땅이면 0
					graph[i][j] = 0;
				} else if (a == 'X') { // 돌이면 -1
					graph[i][j] = -1;
				} else if (a == '*') { // 물이면 -2
					graph[i][j] = -2;
					waterq.add(new int[] { i, j });
				} else if (a == 'S') { // 고슴도치면 1
					graph[i][j] = 1;
					x_pos = i;
					y_pos = j;
				} else if (a == 'D') { // 굴이면 -4
					graph[i][j] = -4;
				}
			}
		}
		bfs();
		System.out.println("KAKTUS");
	}
}