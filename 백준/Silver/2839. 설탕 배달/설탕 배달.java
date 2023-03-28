import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 100];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = -1;
		dp[2] = -1;
		dp[3] = 1;
		dp[4] = -1;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = -1;
		dp[8] = 2;
		dp[9] = 3;
		dp[10] = 2;
		dp[11] = 3;
		dp[12] = 4;
		dp[13] = 3;

		for (int i = 13; i <= N; i++) {

			if (i % 3 == 0) {
				dp[i] = i / 3;
			}
			if (i % 5 == 0) {
				dp[i] = i / 5;
			}

			else {
				dp[i] = Math.min(Math.min((dp[i-5]+1),(dp[i-3]+1)), dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
}