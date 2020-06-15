package queue;

public class Test1 {
    public static void main(String[] args) {
        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
        }
        System.out.println(linkedListQueue);
        System.out.println(linkedListQueue.getSize());

        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
        System.out.println(linkedListQueue.getSize());
    }
}
