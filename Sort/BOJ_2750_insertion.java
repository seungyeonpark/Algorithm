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
            int target = nums[i];
            
            int j = i - 1;
            
            while (j >= 0 && target < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            
            nums[j + 1] = target;
        }
        
        for (int val : nums) {
            System.out.println(val);
        }
    }
}