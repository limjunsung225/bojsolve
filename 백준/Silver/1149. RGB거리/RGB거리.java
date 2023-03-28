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

	static int N;
	static int[][] dp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		dp = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < N; i++) {
		    dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + dp[i][0];
		    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + dp[i][1];
		    dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + dp[i][2];
		}
		for( int[]i : dp) {
			Arrays.sort(i);
		}
		System.out.println(dp[dp.length-1][0]);
	}
}
