import java.util.Scanner;

public class Main {
	static int N, M, cheese = 0, cnt = 0, time = 0;
	static int[][] graph;
	static boolean[][] visited;
	static int[] now_cheese;

	public static void checkCheese(int x, int y) {
	    if (x <= -1 || x >= N || y<=-1 || y >= M) {
	        return;
	    }
	    if (!visited[x][y] && (graph[x][y] == 0 || graph[x][y] == 9)) {
	        graph[x][y] = 10;
	        checkCheese(x, y-1);
	        checkCheese(x, y+1);
	        checkCheese(x-1, y);
	        checkCheese(x+1, y);
	    }
	}

	public static void removeCheese(int x, int y) {
	    if (x < 0 || x >= N || y < 0 || y >= M) {
	        return;
	    }
	    if (!visited[x][y] && graph[x][y] == 1 && (graph[x][y-1] == 9 || graph[x][y+1] == 9 || graph[x-1][y] == 9 || graph[x+1][y] == 9)) {
	        graph[x][y] = -3;
	        cnt++;
	    }
	}
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    M = sc.nextInt();
	    graph = new int[N][M];
	    visited = new boolean[N][M];
	    now_cheese = new int[1000000]; 

	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            graph[i][j] = sc.nextInt();
	            if (graph[i][j] == 1) {
	                cheese++;
	            }
	        }
	    }
	    
	    while (true) {
	        if (cheese == 0) {
	            System.out.println(time);
	            System.out.println(now_cheese[time-1]);
	            break;
	        }

	        checkCheese(0, 0);

	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                if (graph[i][j] == 10) {
	                    graph[i][j] = 9;
	                }
	            }
	        }

	        visited = new boolean[N][M];
	        cnt = 0;
	        now_cheese[time] = cheese;

	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                if (!visited[i][j]) {
	                    removeCheese(i, j);
	                }
	            }
	        }
	        cheese -= cnt;

	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                if (graph[i][j] == -3) {
	                    graph[i][j] = 9;
	                }
	            }
	        }
	        time++;
	    }
	}
}