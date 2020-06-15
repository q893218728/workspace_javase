package Stack;


import linkedList.MyLinkedList;
import queue.LinkedListQueue;

/**
 * 基于链表实现的栈
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {
    private MyLinkedList<E> list;

    public LinkedListStack() {
       list = new MyLinkedList();
    }

    @Override
    public void push(E e) {
       list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:top");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {

            LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
            for (int i = 0; i < 10; i++) {
                linkedListStack.push(i);
                System.out.println(linkedListStack);
            }
            linkedListStack.pop();
            System.out.println(linkedListStack);

    }
}
