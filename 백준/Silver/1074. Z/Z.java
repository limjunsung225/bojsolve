import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int r;
	static int c;
	static int count;

	public static void recur(int length, int y_pos, int x_pos) {
		if (x_pos == c &&  y_pos == r) {
			System.out.println(count);
			return;
		}
		
		if (x_pos <= c && (x_pos + length) > c  && y_pos <= r && (y_pos + length) > r) {
			int index = length / 2;
			recur(index, y_pos, x_pos);
			recur(index, y_pos, x_pos + index);
			recur(index, y_pos + index, x_pos);
			recur(index, y_pos + index, x_pos + index);
		} else
			count += (int)Math.pow(length, 2);
		
	}
	
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        int k = (int) Math.pow(2, N);
        recur(k,0,0);
    }

}