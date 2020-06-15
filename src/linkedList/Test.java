package linkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i);
        }
        linkedList.add(2,66);
        System.out.println(linkedList);
        System.out.println(linkedList.remove(2));
        System.out.println(linkedList);

        System.out.println(linkedList);
    }
}
