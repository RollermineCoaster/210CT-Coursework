
import java.util.Random;

public class Basic_week5_q8 {

    public static int binarySearch(int[] array, int key, int start, int end) {
        int mid = end - start;
        if (array[mid] < key) {
            return binarySearch(array, key, mid + 1, end);
        } else if (array[mid] > key) {
            return binarySearch(array, key, start, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {

        Random ran = new Random();

        int[] array = {9, 21, 32, 44, 66, 72, 90};
        System.out.println("search 72: " + binarySearch(array, 72, 0, array.length - 1));
        System.out.println("search 9: " + binarySearch(array, 9, 0, array.length - 1));
        System.out.println("search 90: " + binarySearch(array, 90, 0, array.length - 1));

        int[] array2 = new int[ran.nextInt(100) + 1];
        System.out.println("\nArray size: " + array2.length);
        System.out.print("[ ");
        for (int i = 0; i < array2.length; i++) {
            array2[i] = ran.nextInt(100 / array2.length) + i * 100 / array2.length;
            System.out.print(array2[i] + " ");
        }
        System.out.println("]");
        int temp = ran.nextInt(array2.length);
        int search = binarySearch(array2, array2[temp], 0, array2.length - 1);
        System.out.println("search " + array2[temp] + ": " + search);
        System.out.println("correct? " + (temp == search));
    }
}
