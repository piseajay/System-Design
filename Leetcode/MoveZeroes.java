import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {

        moveZeroesToEnd(new int[]{0});
    }

    public static void moveZeroesToEnd(int[] arr) {

        int nonZeroIndex = -1;
        int zeroCounter = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                arr[++nonZeroIndex] = arr[i];
            } else {
                zeroCounter++;
            }
        }

        for (int j = arr.length - 1; j >= arr.length - zeroCounter; j--) {
            arr[j] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }
}
