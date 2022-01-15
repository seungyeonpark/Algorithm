import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = Integer.parseInt(br.readLine());
        int[] nums = new int[cnt];
        
        for (int i = 0; i < cnt; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 1; i < cnt; i++) {
            for (int j = 0; j < cnt - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        
        for (int val : nums) {
            System.out.println(val);
        }
    }
}