package in.stackroute.searchMatrix;

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<3;i++){
            if(matrix[i][0]<=target && matrix[i][3]>=target){
                for(int j=0;j<4;j++){
                    System.out.println(matrix[i][j]);
                    if(matrix[i][j]==target){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(arr,2));
    }
}
