import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
	static int N, M;
    static int [][] sum_List, numbers;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
 
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        numbers = new int[N + 1][N+ 1];
        sum_List = new int[N+1][N+1];
        
        for (int i = 1; i <= N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                numbers[i][j] = Integer.parseInt(arr[j - 1]);
            }
        }
        
        for(int i=1; i<=N; i++){
            sum_List[1][i]=numbers[1][i]+sum_List[1][i-1];
            sum_List[i][1] = numbers[i][1]+sum_List[i-1][1];
        }
 
        for(int i=2; i<=N; i++){
            for(int j=2; j<=N; j++){
                sum_List[i][j]= sum_List[i-1][j]+sum_List[i][j-1]-sum_List[i-1][j-1] + numbers[i][j];
            }
        }
 
        for (int i = 0; i < M; i++) {
        	int result = 0;
            String[] arr = br.readLine().split(" ");
            int x1 = Integer.parseInt(arr[0]);
            int y1 = Integer.parseInt(arr[1]);
            int x2 = Integer.parseInt(arr[2]);
            int y2 = Integer.parseInt(arr[3]);
            result += sum_List[x2][y2]-(sum_List[x1-1][y2]+sum_List[x2][y1-1]-sum_List[x1-1][y1-1]);
            System.out.println(result);
        }
    }
}