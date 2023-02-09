import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt(); // 문자열 길이
		int P = sc.nextInt(); // 부분문자열 길이
		char[] arr = new char[S];
		String dna = sc.next();

		int result = 0; // 결과값
		int[][] dna_arr = new int[S + 1][4];

		for (int i = 0; i < dna.length(); i++) {
			arr[i] = dna.charAt(i);
		}

		int A = sc.nextInt();
		int C = sc.nextInt();
		int G = sc.nextInt();
		int T = sc.nextInt();

		for (int i = 1; i <= dna.length(); i++) {
			dna_arr[i][0] = dna_arr[i - 1][0];
			dna_arr[i][1] = dna_arr[i - 1][1];
			dna_arr[i][2] = dna_arr[i - 1][2];
			dna_arr[i][3] = dna_arr[i - 1][3];

			switch (arr[i - 1]) {
			case 'A':
				++dna_arr[i][0];
				break;
			case 'C':
				++dna_arr[i][1];
				break;
			case 'G':
				++dna_arr[i][2];
				break;
			case 'T':
				++dna_arr[i][3];
				break;
			}
		}

		
		for (int i = 0; i <= S - P; i++) {
				if ((dna_arr[P + i][0] - dna_arr[i][0]) < A)
					continue;
				if ((dna_arr[P + i][1] - dna_arr[i][1]) < C)
					continue;
				if ((dna_arr[P + i][2] - dna_arr[i][2]) < G)
					continue;
				if ((dna_arr[P + i][3] - dna_arr[i][3]) < T)
					continue;
			++result;
		}
		System.out.println(result);
	}
}