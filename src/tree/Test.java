package tree;

public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] arr = {5,3,6,8,4,2,1};
        for (int i : arr) {
            bst.add(i);
        }
        System.out.println(bst);

        bst.levelOrder();

        System.out.println(bst.maximum());
        System.out.println(bst.minimum());
        bst.removeMax();
        System.out.println(bst);
        bst.removeMax();
        System.out.println(bst);
    }
}
