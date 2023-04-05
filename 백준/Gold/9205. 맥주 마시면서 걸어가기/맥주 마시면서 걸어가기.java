import java.util.Scanner;

public class Main {

	static int N;
	static int[][] graph, store;
	static int[] visited;

	static void findStore() {
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				if (i == j)
					continue;
				if (Math.abs(graph[i][0] - graph[j][0]) + Math.abs(graph[i][1] - graph[j][1]) <= 1000) {
					store[i][j] = 1;
					store[j][i] = 1;
				}
			}
		}
	}

	static void dfs(int now) {
		visited[now] = 1;
		for (int i = 0; i < N + 2; i++) {
			if (store[now][i] == 1 && visited[i] == 0) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			N = sc.nextInt();
			graph = new int[N + 2][2];
			for (int j = 0; j < N + 2; j++) {
				graph[j][0] = sc.nextInt();
				graph[j][1] = sc.nextInt();
			}
			store = new int[N + 2][N + 2];
			visited = new int[N + 2];
			findStore();
			dfs(0);
			if (visited[N + 1] == 1) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}
}