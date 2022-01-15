import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(ary, value, 0, n - 1));
        }
    }
    
    public static int binarySearch(int[] ary, int value, int l, int r) {
        if (l > r) {
            return 0;
        }
        
        int mid = (l + r) / 2;
        
        if (ary[mid] > value) {
            return binarySearch(ary, value, l, mid - 1);
        } else if (ary[mid] < value) {
            return binarySearch(ary, value, mid + 1, r);
        } else {
            return 1;
        }
    }
}