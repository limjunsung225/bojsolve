import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i =1;i<=10;i++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			String [] arr = br.readLine().split(" ");
			Integer[] newArr = Stream.of(arr).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
			while (true) {
				Arrays.sort(newArr);
				if (cnt==N)break;
				if (newArr[99]-newArr[0]<=1)break;
				
				newArr[99] -=1;
				newArr[0] += 1;
				cnt +=1;
			}

			System.out.printf("#%d %d",i,newArr[99]-newArr[0]);
			System.out.println();
		}
	}
}