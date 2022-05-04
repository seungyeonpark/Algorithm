import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        String s = sc.next();
        char[] ary = s.toCharArray();
        int sum = 0;
        
        for (char c : ary) {
            sum += c - '0';
        }
        System.out.println(sum);
	}
}