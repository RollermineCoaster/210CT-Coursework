
public class Basic_week7_q11 {

    public static void main(String[] args) {
        int[] array = {13, 5, 59, 29};
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
        bubbleSort(array);
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public static void bubbleSort(int[] array) {
        for (int pass = 0; pass < array.length - 1; pass++) {
            for (int i = 0; i < array.length - pass - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
