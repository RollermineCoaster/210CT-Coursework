
import java.util.Scanner;

public class Basic_week7_q12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array;
        String s = "[ ";
        System.out.print("Please enter the array size: ");
        array = new int[in.nextInt()];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Please enter the value in array[" + i + "]: ");
            array[i] = in.nextInt();
            s += array[i] + " ";
        }
        System.out.println(s+"]");
        quicksort(array, 0, array.length - 1);
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public static void quicksort(int[] array, int low, int high) {
        int pivotIndex = low;
        int storeIndex = pivotIndex + 1;
        for (int i = pivotIndex + 1; i <= high; i++) {
            if (array[i] < array[pivotIndex]) {
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        swap(array, pivotIndex, storeIndex - 1);
        pivotIndex = storeIndex - 1;
        if (pivotIndex - 1 > low) {
            quicksort(array, low, pivotIndex - 1);
        }
        if (pivotIndex + 1 < high) {
            quicksort(array, pivotIndex + 1, high);
        }
    }

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
