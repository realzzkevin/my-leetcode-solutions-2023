public class Solution {
	public int tribonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        int x = 0;
        int y = 1;
        int z = 1;
        for(int i = 3; i <= n; i++) {
            int temp = z;
            z = x+y+z;
            x = y;
            y = temp;
            System.out.println(z);
            
        }
        return z;
        
    }
}

