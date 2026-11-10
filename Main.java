public class Main {
    public static void main (String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] weights1 = {1,2,3,4,5,6,7,8,9,10};
        int days1 = 5;
        System.out.println(solution.shipWithinDays(weights1, days1));
        
        // Test case 2
        int[] weights2 = {3,2,2,4,1,4};
        int days2 = 3;
        System.out.println(solution.shipWithinDays(weights2, days2));
        
        // Test case 3
        int[] weights3 = {1,2,3,1,1};
        int days3 = 4;
        System.out.println(solution.shipWithinDays(weights3, days3));
    }
}