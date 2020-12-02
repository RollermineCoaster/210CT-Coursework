
public class Basic_week6_q10 {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] data = {21, 7, 19, 4, 11, 5, 3, 6, 12, 8, 28, 1};
        for (int i = 0; i < data.length; i++) {
            tree.addNode(data[i]);
        }
        tree.inorder();
        System.out.println("");
        tree.deleteNode(7);
        tree.inorder();
        System.out.println("");
    }
}
