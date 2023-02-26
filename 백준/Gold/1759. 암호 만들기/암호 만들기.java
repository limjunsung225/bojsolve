import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static String mo_word;
	static String[] numbers;
	static boolean[] isSelected;
	static String[] arr;

	public static void comb(int cnt, int start) {
		if (cnt == L) {
			int mo_check = 0;
			int ja_check = 0;
			for (String str : numbers) {
				if (mo_word.contains(str))
					mo_check += 1;
				else {
					ja_check += 1;
				}
			}
			// 만약 정렬된 단어라면

			if (mo_check >= 1 && ja_check >= 2) { // 자음 모음 최소 횟수를 사용했고
				String word1=  String.join("", numbers);
				Arrays.sort(numbers);
				String word2 = String.join("", numbers);
				if(word1.equals(word2)) {
					System.out.println(word1);
				}
			}

			return;
		}

		for (int i = start; i < C; i++) {
			numbers[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		mo_word = "aeiou";
		arr = br.readLine().split(" ");
		Arrays.sort(arr);

		numbers = new String[L];
		isSelected = new boolean[C];
		comb(0,0);

	}
}