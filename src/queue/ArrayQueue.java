package queue;

import Array.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        this.array = new Array<E>(capacity);
    }

    public ArrayQueue(){
        this.array = new Array<E>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
         array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFast();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue:");
        res.append("队首[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            //最后一个元素不用写逗号
            if (i != getSize() - 1) {
                res.append(',');
            }
        }
        res.append("]队尾");
        return res.toString();

    }
}
