import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static long tree[], nums[];

	static void setTree(int i, long num) {
		while (i < N + 1) {
			tree[i] += num;
			i += i & (-i);
		}
	}

	static void update(int i, long nextNum) {
		long preNum = nums[i];
		nums[i] = nextNum;
		while (i < N + 1) {
			tree[i] += nextNum - preNum;
			i += i & (-i);
		}
	}

	static long sum(int i) {
		long ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}

	static long presum(int start, int end) {
		if (end > start)
			return sum(end) - sum(start - 1);
		else
			return sum(start) - sum(end - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		tree = new long[N + 1];
		nums = new long[N + 1];

		for (int i = 1; i < N + 1; i++) {
			nums[i] = Long.parseLong(br.readLine());
			setTree(i, nums[i]);
		}

		for (int i = 0; i < M + K; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				update(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
			} else if (a == 2) {
				System.out.println(presum(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
		}
	}
}