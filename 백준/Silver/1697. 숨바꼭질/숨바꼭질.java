
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, K, result;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int[] visited = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 수빈이 위치
		K = sc.nextInt(); // 동생 위치
		q.add(N);
		bfs();
	}

	public static void bfs() {

		while (!q.isEmpty()) {

			int cur = q.poll();

			if (cur == K) {
				System.out.println(visited[cur]);
				System.exit(0);
			}

			int[] now = new int[3];
			now[0] = cur - 1;
			now[1] = cur + 1;
			now[2] = cur * 2;

			for (int i : now) {
				if (i >= 0 && i <= 100000 && visited[i] == 0) {
					visited[i] = visited[cur] + 1;
					q.add(i);
				}
			}
		}
	}
}
