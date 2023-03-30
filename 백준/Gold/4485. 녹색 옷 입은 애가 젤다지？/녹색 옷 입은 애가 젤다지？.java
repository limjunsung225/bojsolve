import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] graph;
	static int[][] map;
	static ArrayList<Integer> q = new ArrayList<>();
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, 1, -1, 0 };
	static int inf = Integer.MAX_VALUE;

	public static boolean is_Okay(int x, int y) {
		if (x <= -1 || x >= N || y <= -1 || y >= N) {
			return false;
		}
		return true;
	}

	public static void bfs() {

		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(0);
		
		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (is_Okay(nx, ny)) {
					if (map[nx][ny]<= map[x][y]+ graph[nx][ny])continue;
					map[nx][ny] = map[x][y] + graph[nx][ny];
					q.add(nx);
					q.add(ny);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 1;
		while (true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N==0)break;
			graph = new int[N][N];
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] = inf;
				}
			}
			
			map[0][0] = graph[0][0];
			bfs();
			System.out.println("Problem " + tc++ + ": " + map[N-1][N-1]);
		}
	}
}