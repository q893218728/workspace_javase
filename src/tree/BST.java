package tree;


import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 一个不包含重复元素的二分搜索树
 *
 * @param <E> E代表的是实现了Comparable接口的类型。
 */
public class BST<E extends Comparable<E>> {


    private class Node {
        private E e;
        private Node left;
        private Node right;


        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private int size;
    private Node root;

    public BST() {
        size = 0;
        root = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }



    public void add(E e) {
        //如果没有根，做根
        if (root == null) {
            root = new Node(e);
            size++;
        }
        //如果有根
        else {
            add(root, e);
        }
    }

    //向以node为根的二分搜索树，插入元素e。递归方法。
    //根是在不断变化的
    private void add(Node node, E e) {
        //如果相等，直接结束
        if (e.equals(node.e)) {
            return;
        }
        //如果e小于node的e,并且左子树是空，放这里。
        else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }
        //如果e大于node的e，并且右子树为空，放这里。
        else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        //上面的是递归终止条件。
        //下面是递归调用
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }




     public boolean contains(E e) {
        return contains(root, e);
    }

    //以node为根的二分搜索树,是否含有元素e
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }

    }


    //最大值和最小值不一定是最小节点。而是左边直到没有叶子节点的节点。 和右边直到没有叶子节点的节点

    //寻找二分搜索树最小元素
    public E minimum(){
        if(size==0){
            throw new IllegalArgumentException("树为空");
        }
        Node node = minimum(root);
        return node.e;
    }

    private Node minimum(Node node){

        if(node.left==null){
            return node;
        }

        return minimum(node.left);
    }

    //寻找二分搜索树最大元素
    public E maximum(){
        if(size==0){
            throw new IllegalArgumentException("树为空");
        }

        Node node = maximum(root);
        return node.e;
    }

    private Node maximum(Node node){
        if(node.right==null){
            return node;
        }

        return maximum(node.right);
    }

    //删除节点
    //删除最小值和最大值
    //如果要删除最小值。最小值是叶子节点的话可以直接删除。如果说最小值还有右子树就没办法删除了。应该将右子树挂到这个节点现在的位置来才行。
    //最大值同理
    public E removeMin(){
        E ret  = minimum();
        root = removeMin(root);

        return ret;
    }

    //删除掉以node为根的这棵树的最小值  返回删除节点后新二分搜索树的根
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode = node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;

    }


    public E removeMax(){
       E e =  maximum();
       root = removeMax(root);
       return e;
    }
    private Node removeMax(Node node){

        if(node.right==null){
            Node leftNode = node.left;
            node.left=null;
            size--;
            return leftNode;
        }

        node.right= removeMax(node.right);
        return node;
    }


    //删除二分搜索树的任意元素
    //删除只有左孩子的节点。跟删除最大节点差不多
    //删除只有右孩子的节点。跟删除最小节点差不多
    //最难的是删除左右都有孩子的节点。

    //二叉搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

   //前序遍历的非递归实现，使用栈。比递归复杂。
    public void preOrderByStack() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

        }
    }

    //二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.e + "  ");
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + "  ");
    }

    //层序遍历，广度优先遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }


        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);


    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
