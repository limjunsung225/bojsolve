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
	
	static int K, M, N;
	static int[][] graph;
	static boolean[][][] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] dx1 = {0, 1, 0, -1};
	static int[] dy1 = {1, 0, -1, 0};
	static int[] dx2 = {1, 2, -1, -2, 1, 2, -1, -2};
	static int[] dy2 = {2, 1, 2, 1, -2, -1, -2, -1};

	public static void main(String[] args) throws IOException {
	    K = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());

	    visited = new boolean[K + 1][N][M];
	    graph = new int[N][M];

	    for (int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < M; j++) {
	            graph[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    Queue<int[]> q = new LinkedList<>();
	    q.offer(new int[]{0, 0, 0, K});
	    visited[K][0][0] = true;

	    while (!q.isEmpty()) {
	        int[] cur = q.poll();
	        int x = cur[0], y = cur[1], cnt = cur[2], temp = cur[3];

	        if (x == N - 1 && y == M - 1) {
	            System.out.println(cnt);
	            System.exit(0);
	        }

	        for (int i = 0; i < 4; i++) {
	            int nx = x + dx1[i];
	            int ny = y + dy1[i];

	            if (nx < 0 || nx >= N || ny < 0 || ny >= M || graph[nx][ny] != 0 || visited[temp][nx][ny]) continue;

	            visited[temp][nx][ny] = true;
	            q.offer(new int[]{nx, ny, cnt + 1, temp});
	        }

	        if (temp > 0) {
	            temp--;

	            for (int i = 0; i < 8; i++) {
	                int nx = x + dx2[i];
	                int ny = y + dy2[i];

	                if (nx < 0 || nx >= N || ny < 0 || ny >= M || graph[nx][ny] != 0 || visited[temp][nx][ny]) continue;

	                visited[temp][nx][ny] = true;
	                q.offer(new int[]{nx, ny, cnt + 1, temp});
	            }
	        }
	    }

	    System.out.println(-1);
	}
}
