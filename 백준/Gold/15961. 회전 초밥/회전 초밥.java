import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, D, K, C, result, cnt, k;
	static int[] visited;
	static Queue<Integer> q;
	static Queue<Integer> sushi;

	//
	public static void firstSushsi() {

		cnt = 0;
		for (int i = 0; i < K; i++) {
			k = q.poll();
			sushi.add(k);
			q.add(k);
			if (visited[k] == 0) {
				visited[k] = 1;
				cnt++;
			} else if (visited[k] >= 1) {
				visited[k] += 1;
			}
		}
	}

	public static void setCoupon(int coupon) {
		if (visited[coupon] == 0) {
			visited[coupon] = 1;
			cnt++;
		} else if (visited[coupon] >= 1) {
			visited[coupon] += 1;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		q = new ArrayDeque<>();
		sushi = new ArrayDeque<>();
		visited = new int[D + 2];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			q.add(num);
		}

		firstSushsi(); // 첫 스시 세팅하고 시작
		setCoupon(C);
		result= 0;
		for (int i = 0; i < N - 1; i++) {

			int now = q.poll();
			int bye = sushi.poll();
			sushi.add(now);
			q.add(now);
			
			if (visited[bye] == 1) {
				visited[bye] = 0;
				cnt--;
			} else if (visited[bye] >= 2) {
				visited[bye] -= 1;
			}
			
			if (visited[now] == 0) {
				visited[now] = 1;
				cnt++;
			} else if (visited[now] >= 1) {
				visited[now] += 1;
			}
			setCoupon(C);
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}
}
