import java.util.Arrays;

public class ReverseArrayChallenge {

    private static int[] reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(arr));
        int[] arr2 = reverseArray(arr);
        System.out.println(Arrays.toString(arr2));
    }
}
