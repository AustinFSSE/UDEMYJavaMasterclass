import java.util.Random;
import java.util.Scanner;

public class SortedArray {
    // write code here
    public static int[] getIntegers(int len) {

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Random().nextInt(100);
        }
        return arr;
    }
    public static void printArray(int[] arr) {
        int i = 0;
        for (int j : arr) {
            System.out.print("Element " + i + " contents " + j + "\n");
            i++;
        }
    }
    public static int[] sortIntegers(int[] arr) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        printArray(sortIntegers(getIntegers(3)));
    }
}