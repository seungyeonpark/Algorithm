import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && s.charAt(i) == ' ' || i == s.length() - 1 && s.charAt(i) != ' ') {
                cnt++;
            }
        }
        System.out.println(cnt);
	}
}