package linkedList;

public class MyLinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node dummyHead;
    int size;

    public MyLinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }
    //获取链表中的元素个数

    public int getSize() {
        return size;
    }

    //返回这个链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }



    //在链表的index位置添加一个元素，在链表中不是一个常用操作，基本不用，这里仅当做练习
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("越界");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;//最后得到待插入节点的前面那个节点的元素
        }
            /*Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;*/
        prev.next = new Node(e, prev.next);
        size++;

    }
    //在链表头添加元素
    public void addFirst(E e) {
        add(0,e);
    }

    public void addLast(E e) {
        add(size, e);
    }
    public E get(int index){
        if(index<0||index>=size){
          throw new IllegalAccessError("查询越界");
        }
        Node cur = dummyHead.next;//这里是从虚拟头结点的下一个开始遍历的
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size - 1);
    }
    public void set(int index,E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("越界");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    //是否存在某个元素
    public boolean contains(E e){

        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e==e){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public E remove(int index){
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;//我们要找的是index节点的上一个
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }
    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }
    @Override
    public String toString() {
        Node cur = dummyHead.next;
        StringBuilder res= new StringBuilder();
        while(cur!=null){
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
