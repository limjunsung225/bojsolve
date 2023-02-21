import java.util.Scanner;

public class Main {

	  static int[] dx = {0, 0, 1, -1};
	  static int[] dy = {1, -1, 0, 0};
	  static int ans, next = 0;
	  
	  public static void dfs(String[] board, boolean[] check, int x, int y, int next) {
	        if (ans < next) {
	            ans = next;
	        }
	         
	        for (int k=0; k<4; k++) {
	            int nx = x+dx[k];
	            int ny = y+dy[k];
	            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length()) {
	                if (check[board[nx].charAt(ny)-'A'] == false) {
	                	
	                    check[board[nx].charAt(ny)-'A'] = true;
	                    dfs(board, check, nx, ny, next+1);
	                    check[board[nx].charAt(ny)-'A'] = false;
	                    
	                }
	            }
	        }
	    }
	 
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        sc.nextLine();
	        String[] board = new String[n];
	        
	        for (int i=0; i<n; i++) {
	            board[i] = sc.nextLine();
	        }
	        
	        boolean[] check = new boolean[26];
	        check[board[0].charAt(0)-'A'] = true;
	        
	        dfs(board, check, 0,0,1);
	        System.out.println(ans);
	    }
	}