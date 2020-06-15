package queue;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);//放元素
    E dequeue();//取元素
    E getFront();//查看队首是谁。

}
