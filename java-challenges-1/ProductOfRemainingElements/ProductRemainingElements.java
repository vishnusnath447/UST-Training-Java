package ProductOfRemainingElements;

public class ProductRemainingElements {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{2, 8, 4, 1}));
        System.out.println(canPartition(new int[]{-1, -10, 1, -2, 20}));
        System.out.println(canPartition(new int[]{-1, -20, 5, -1, -2, 2}));
    }

    private static boolean canPartition(int[] arr) {
        int item = 0;
        int product;
        for(int i:arr) {
            item=i;
            product=1;
            for(int j : arr) {
                if (i != j) {
                    product = product * j;
                }
            }
            if(item==product){
                return true;
            }
        }
        return false;
    }
}
