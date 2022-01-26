import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[][] memo = new int[n + 1][k + 1];
        
        int[][] product = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            product[i][0] = sc.nextInt();
            product[i][1] = sc.nextInt();
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
               int space = product[i][0];
               if (space > j) {
                   memo[i][j] = memo[i - 1][j];
                   continue;
               }
               
               memo[i][j] = Math.max(memo[i - 1][j], product[i][1] + memo[i - 1][j - space]);
            }
        }
        
        System.out.println(memo[n][k]);
    }
}