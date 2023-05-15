import java.util.Arrays;
import java.util.Random;

public class ArrayRearranger {
    private static Random random = new Random();

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int[] rearrangedArray = randomizeArray(array);

        System.out.println(Arrays.toString(rearrangedArray));
    }

    public static int[] randomizeArray(int[] array) {
        int length = array.length;
        int[] rearrangedArray = array.clone();

        for (int i = length - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            int temp = rearrangedArray[randomIndex];
            rearrangedArray[randomIndex] = rearrangedArray[i];
            rearrangedArray[i] = temp;
        }

        System.out.println(rearrangedArray);
        return rearrangedArray;
    }
}