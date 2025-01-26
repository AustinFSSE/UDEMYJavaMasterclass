
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int findMin(int[] arr) {
        int min = arr[0];
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

    private static int[] readIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers, separated by commas:");
        String input = scanner.nextLine();

        String[] splitStrings = input.split(",");
        int[] arr = new int[splitStrings.length];
        for (int i = 0; i < splitStrings.length; i++) {
            arr[i] = Integer.parseInt(splitStrings[i].trim());
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static void main(String[] args) {
       System.out.println(findMin(readIntegers()));
    }
}