import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, a, b, result;
	static int graph[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		graph = new int[N + 1][N + 1]; // 인덱스

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1; // 인접행렬 정보 저장
		}

		for (int i = 1; i <= N; i++) { // floydwarshall
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (graph[j][i] == 1 && graph[i][k] == 1) {
						graph[j][k] = 1;
					}
				}
			}
		}

		result = 0; // 결과값
		for (int i = 1; i <= N; i++) {
			boolean check = true;
			for (int j = 1; j <= N; j++) {
				if (i != j) { // 같지 않을 떄
					if (graph[i][j] != 1 && graph[j][i] != 1) { // 둘중 하나라도 연결되어 있어야 키를 비교할 수있다.
						check = false;
						break;
					}
				}
			}
			if (check) {
				result += 1;
			}
		}
		sb.append(result);
		System.out.println(sb.toString());
	}
}