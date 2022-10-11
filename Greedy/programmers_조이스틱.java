class Solution {
    public int solution(String name) {
        int length = name.length();
        int vertical = 0;
        int horizontal = length - 1;
        
        for (int i = 0; i < length; ++i) {
            vertical += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int j = i + 1;
            while(j < length && name.charAt(j) == 'A') {
                j++;
            }
            
            if (j == length) {
                horizontal = Math.min(horizontal, i);
            } else if (j != i + 1) {
                horizontal = Math.min(horizontal, i * 2 + length - j);
                horizontal = Math.min(horizontal, (length - j) * 2 + i);
            }
        }
        
        return vertical + horizontal;
    }
}