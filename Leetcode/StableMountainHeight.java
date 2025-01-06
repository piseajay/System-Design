import java.util.ArrayList;
import java.util.List;

public class StableMountainHeight {

    public static void main(String[] args) {
        System.out.println(stableMountains(new int[]{10,1,10,1,10}, 10));
    }

    public static List<Integer> stableMountains(int[] height, int threshold) {

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                result.add(i);
            }
        }
        return result;
    }
}
