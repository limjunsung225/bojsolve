import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
		
		
	public static void main(String[] args)  throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = bf.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		int [] sumList = new int[N+1];
		int[] numbers = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for(int i=1;i<=N;i++) {
			sumList[i] += numbers[i-1] + sumList[i-1];
		}
		
		for(int i=1;i<=M;i++) {
			String [] arr2 = bf.readLine().split(" ");
			int K = Integer.parseInt(arr2[0]);
			int T = Integer.parseInt(arr2[1]);
			System.out.println(sumList[T]-sumList[K-1]);
		}	
	}

}