import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 우선 1/9 , 2/8 , 3/7 나올수 있는 모든 경우의수를 combination으로 배열을 만들어둔다. 각각의 합을 더해서 정렬해놓고,
 * 최소값인 경우의 수 부터 완전 탐색을 시작한다. 그 이유는 처음부터 정해놓지 않고 완전탐색을 하는 것보다 최소값에서 시작하는게 훨씬
 * 효율적이기 때문
 * 
 * 완전탐색은 다음과 같은 방식으로 할 예정 나눠진 구역에 따라 makeset을 하고, 모두 같은 집합이면 flag +=1 나머지 구역은 1일
 * 때는 무조건 ok이고, 나머지의 경우에는 그 집합끼리 union find를 하여 서로소집합이면 flag += 1
 * 
 * flag == 2 이면 가능한 방법이라는 뜻이고, 가장 빨리 찾는 result가 최소값이 된다.
 *
 */

public class Main {

	static int N, min_result = 10000;
	static int list[], group[], copy_group[];
	static boolean graph[][];
	static int parents[];

	public static void bfs(Queue<Integer> q, int teamgroup) {
		while (!q.isEmpty()) {
			int i = q.poll();

			for (int j = 1; j <= N; j++) {
				if (graph[i][j] && copy_group[j - 1] == teamgroup) {
					copy_group[j - 1] = 0;
					q.add(j);

				}
			}
		}
	}

	public static void subSet(int cnt, int g1_score, int g2_score) {
		if (g1_score == N || g2_score == N)
			return;

		if (cnt == N) {
			isSelected(g1_score, g2_score);
			return;
		}

		group[cnt] = 1;
		subSet(cnt + 1, g1_score + 1, g2_score);
		group[cnt] = 2;
		subSet(cnt + 1, g1_score, g2_score + 1);
	}

	public static void isSelected(int g1_score, int g2_score) {
		copy_group = Arrays.copyOf(group, group.length);
		int team1 = 0;
		int team2 = 0;
		int result = 0;

		for (int i = 0; i < group.length; i++) {
			boolean flag = false;
			if (group[i] == 1) {
				int from = i + 1;
				for (int j = 1; j <= N; j++) {
					if (graph[from][j] && group[j - 1] == group[i]) {
						flag = true;
						break;
					}
				}
				if (g1_score == 1)flag = true;
				if (flag == false)return;
				
				team1 += list[i + 1];
			} else {
				int from = i + 1;
				for (int j = 1; j <= N; j++) {
					if (graph[from][j] && group[j - 1] == group[i]) {
						flag = true;
						break;
					}
				}
				if (g2_score == 1)
					flag = true;
				if (flag == false)
					return;
				team2 += list[i + 1];
			}
		}
		int team1C = 0;
		int team2C = 0;
		for (int i = 0; i < N; i++) {

			if (copy_group[i] == 1) {
				int index = i + 1;
				Queue<Integer> q = new LinkedList<>();
				q.add(index);
				copy_group[i] = 0;
				bfs(q, 1);
				team1C++;
			}

			else if (copy_group[i] == 2) {
				int index = i + 1;
				Queue<Integer> q = new LinkedList<>();
				q.add(index);
				copy_group[i] = 0;
				bfs(q, 2);
				team2C++;

			}
		}

		if (team1C != 1 || team2C != 1)
			return;
		result = Math.abs((team1 - team2));
		min_result = Math.min(result, min_result);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		graph = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = i;
			int connected = Integer.parseInt(st.nextToken());
			for (int j = 0; j < connected; j++) {
				int to = Integer.parseInt(st.nextToken());
				graph[from][to] = true;
				graph[to][from] = true;
			}
		}

		group = new int[N];
		subSet(0, 0, 0);

		if (min_result == 10000) {
			System.out.println(-1);
		} else {
			System.out.println(min_result);
		}
	}

}