package Stack;

public interface Stack<E> {
    void push(E e);//添加
    E pop();//取出
    E peek();//栈顶
    int getSize();
    boolean isEmpty();
}
