import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[][] meeting = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            meeting[i][0] = sc.nextInt();
            meeting[i][1] = sc.nextInt();
        }
        
        Arrays.sort(meeting, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                
                return o1[1] - o2[1];
            }
        });
                    
        int cnt = 0;
        int preMeeting = 0;
        for (int i = 0; i < n; i++) {
            if (meeting[i][0] >= preMeeting) {
                preMeeting = meeting[i][1];
                cnt++;
            }
        }
                    
        System.out.println(cnt);
    }
}