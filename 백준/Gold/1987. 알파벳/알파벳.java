import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	  static int[] dx = {-1, 0, 0, 1};
	  static int[] dy = {0, -1, 1, 0};
	  static int R, C;
	  static int max_result = 0;
	  
	  public static void dfs(String[] graph, boolean[] check, int x, int y, int cnt) {
		  
	        if (cnt>max_result) max_result = cnt;
	         
	        for (int i=0; i<4; i++) {
	            int nx = x+dx[i];
	            int ny = y+dy[i];
	            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
	                if (check[graph[nx].charAt(ny)-'A'] == false) {
	                    check[graph[nx].charAt(ny)-'A'] = true;
	                    dfs(graph, check, nx, ny, cnt+1);
	                    check[graph[nx].charAt(ny)-'A'] = false;
	                }
	            }
	        }
	    }
	 
	    public static void main(String args[]) throws IOException {
	    	
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        StringBuilder sb = new StringBuilder();
	        
	        R = Integer.parseInt(st.nextToken());
	        C = Integer.parseInt(st.nextToken());
	        
	        String[] graph = new String[R];
	        
	        for (int i=0; i<R; i++) {
	            graph[i] = br.readLine();
	        }
	        
	        boolean[] check = new boolean[26];
	        check[graph[0].charAt(0)-'A'] = true;
	        
	        dfs(graph, check, 0,0,1); 
	        
	        sb.append(max_result);
	        System.out.println(sb.toString());
	        
	    }
	}