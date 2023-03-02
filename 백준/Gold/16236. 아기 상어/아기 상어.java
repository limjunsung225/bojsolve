import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, eat_stack, result = 0;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static class Shark { // 상어의 좌표, 크기, 소요된 시간을 담고 있는 클래스
		int x, y, shark_size, time;

		public Shark(int x, int y, int shark_size, int time) {
			this.x = x;
			this.y = y;
			this.shark_size = shark_size;
			this.time = time;
		}
	}

	/**
	 * 
	 * # 신경써야할것 # 1. 먹을 수 있는 물고기가 1마리면 그 물고기를 무조건 먹으러 간다.(bfs돌려서 전체확인) 먹을 수 있는 물고기수
	 * count # 2 # 2-1 먹을 수 있는 물고기 1마리면 그 물고기 먹으러 간다. # 2-2 먹을 수 있는 물고기 2마리 이상이면 거리
	 * 가장 가까운 물고기 먹으러 간다. # 2-2-1 가장 왼쪽 위에 있는 먹을 수 있는 물고기 부터 먹는다. # 먹을 수 있는 물고기가 없으면
	 * 탐색 종료 # 이동할 때는 자신보다 크거나 같은 칸만 이동할 수 있다. # 물고기를 먹을 때 마다 size count를 해서 , 내 물고기
	 * 크기 만큼 먹었을 때 크기가 증가한다.
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		Queue<Shark> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());

				if (graph[i][j] == 9) { // 상어가 발견되면
					graph[i][j] = 0;
					q.add(new Shark(i, j, 2, 0)); // 상어의 현재 위치를 넣고 size는 2로 시작된다.
				}
			}
		}

		while (!q.isEmpty()) {
			Shark shark = q.poll();
			if (!visited[shark.x][shark.y]) { // 방문하지 않은 위치라면
				visited[shark.x][shark.y] = true; // 방문처리하고
				if (graph[shark.x][shark.y] != 0 && graph[shark.x][shark.y] < shark.shark_size) {
					// 만약 먹을 수 있는 상어를 발견하면
					Shark cur = shark;

					while (!q.isEmpty()) { //
						shark = q.poll();
						if (graph[shark.x][shark.y] != 0 && graph[shark.x][shark.y] < shark.shark_size) { // 먹을수 있는 상어 중에서
							if (cur.time == shark.time) { // 가장 시간이 짧은 상어면 
								if (cur.x > shark.x) { // 거리  -> 높이 -> 왼쪽 순으로 que 탐색하며 먹을 상어 위치판별  
									cur = shark;
								} else if (cur.x == shark.x && cur.y > shark.y) {
									cur = shark;
								}
							} else if (cur.time > shark.time) {
								cur = shark;
							}
						}
					}

					graph[cur.x][cur.y] = 0; // 현재 상어가 있던 위치는 0으로 해주고
					eat_stack++; // 먹은 스택 증가
					result += cur.time; // 현재 상어를 먹는 데 걸렸던 시간
					int check = 0; // 사이즈가 커졌는지 체크
					if (eat_stack == cur.shark_size) {
						check = 1;
						eat_stack = 0;
					}

					q.clear(); // 상어의 위치를 지금의 위치로 다시 시작해준다.
					q.add(new Shark(cur.x, cur.y, cur.shark_size + check, 0)); // 커졌으면 증가, 아니면 그대로로 다시 bfs
					visited = new boolean[N][N]; // 방문 초기화
					continue;
				}

				for (int i = 0; i < 4; i++) {
					int nx = shark.x + dx[i];
					int ny = shark.y + dy[i];

					// 맵 밖으로 나가지 않고, 크기가 크거나 같아서 통과 할 수 있으며, 방문한적 없으면
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny] <= shark.shark_size
							&& !visited[nx][ny]) {
						q.add(new Shark(nx, ny, shark.shark_size, shark.time + 1));
					}
				}
			}
		}
		sb.append(result);
		System.out.println(sb.toString());
	}
}