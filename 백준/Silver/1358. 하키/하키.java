import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int p = scanner.nextInt();
        int cnt = 0;
        int r = h/2;
        
        for (int i = 0; i < p; i++) {
            int px = scanner.nextInt();
            int py = scanner.nextInt();
            
            if (Math.pow(px-x, 2) + Math.pow(py-(y+r), 2) <= Math.pow(r, 2)) {
                cnt++;
            } else if (x <= px && px <= x+w && y <= py && py <= y+h) {
                cnt++;
            } else if (Math.pow(px-(x+w), 2) + Math.pow(py-(y+r), 2) <= Math.pow(r, 2)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}