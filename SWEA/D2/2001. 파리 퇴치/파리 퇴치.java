import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max_result = 0; // 최대값을 갱신한다.
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					for (int k = 0; k < M; k++) {
						for (int t = 0; t < M; t++) {
							result += arr[k+i][t+j];
						}
					}
					max_result = Math.max(max_result, result);
					result = 0;
				}
			}
			System.out.printf("#%d %d",tc,max_result);
			System.out.println();
		}
	}
}