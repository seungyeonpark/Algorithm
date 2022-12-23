public class Main {
    public static void main(String args[]) {
        int[] nums = new int[10001];

        for (int n = 1; n <= 10000; ++n) {
            int temp = n;
            int sum = n;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum <= 10000 && nums[sum] == 0) {
                nums[sum] = -1;
            }
        }

        for (int n = 1; n <= 10000; ++n) {
            if (nums[n] == 0) {
                System.out.println(n);
            }
        }
    }
}