package Leetcode;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int low = 0;
        int high = (rowNum * colNum) - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int row = mid / colNum;
            int column = mid % colNum;

            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                high = mid - 1;
            } else {
                low = low + 1;
            }
        }
        return false;
    }

//    public static boolean searchMatrix(int[][] matrix, int target) {
//
//        for (int i = 0; i < matrix.length; i++) {
//            if (matrix[i][0] <= target && target <= matrix[i][matrix[i].length - 1]) {
//                return binarySearch(matrix[i], target);
//            }
//        }
//        return false;
//    }
//
//    public static boolean binarySearch(int[] arr, int target) {
//
//        int low = 0;
//        int high = arr.length - 1;
//
//        while (low <= high) {
//
//            int mid = (low + high) / 2;
//
//            if (arr[mid] == target) {
//                return true;
//            } else if (arr[mid] > target) {
//                high = mid - 1;
//            } else {
//                low = low + 1;
//            }
//        }
//        return false;
//    }
}
