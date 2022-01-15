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
        
        for (int i = 0; i < cnt - 1; i++) {
            int index = i;
            for (int j = i + 1; j < cnt; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
        
        for (int val : nums) {
            System.out.println(val);
        }
    }
}