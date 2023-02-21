import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] graph;
	static StringBuilder sb;

	public static void recur(int r, int c, int size) {
		
		if (size == 1) {
			sb.append(graph[r][c]);
			return;
		}		
		int sum = 0;
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				sum += graph[i][j];			
			}
		}
		
		if (sum == 0) { // 모두 0일때
			sb.append(0);
		} else if (sum == size*size) { // 모두 1일때
			sb.append(1);
		} 
		
		else { // 4분면을 나눠서 recur를 돌린다.
			sb.append("(");
			int t = size / 2;
			recur(r, c, t);
			recur(r, c+t, t);
			recur(r+t, c, t);
			recur(r+t, c+t, t);
			sb.append(")");
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String k = st.nextToken();
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(String.valueOf(k.charAt(j)));
			}
		}
		
		recur(0,0,N);
		System.out.println(sb.toString());
	}

}