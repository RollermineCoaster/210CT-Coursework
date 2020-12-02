
public class Basic_week5_q9 {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] data = {21, 7, 19, 4, 11, 5, 3, 6, 12, 8, 28, 1};
        for (int i = 0; i < data.length; i++) {
            tree.addNode(data[i]);
        }
        tree.inorder();
        System.out.println("");
        BinarySearchTree tree2 = new BinarySearchTree();
        int[] data2 = {202, 2, 12, 21, 9, 90, 41, 69, 57, 39, 30, 8, 4, 5, 60};
        for (int i = 0; i < data2.length; i++) {
            tree2.addNode(data2[i]);
        }
        tree2.inorder();
        System.out.println("");
    }
}
