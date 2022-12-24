import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        for (int i = 1; i <= n; ++i) {

            int temp = i;
            boolean isTarget = true;

            int prev = temp % 10;
            int diff = temp % 10 - (temp / 10 % 10);
            temp /= 10;

            while (temp > 0) {
                int curr = temp % 10;

                if (diff != prev - curr) {
                    isTarget = false;
                    break;
                }

                diff = prev - curr;
                temp /= 10;
                prev = curr;
            }

            if (isTarget) {
                ++cnt;
            }
        }

        System.out.println(cnt);
    }
}