package linkedList;

import Stack.*;


public class Main {
    public static double time(Stack<Integer> stack,int opCount){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < opCount; i++) {
            stack.push(i);
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.currentTimeMillis();
        return (endTime-startTime);
    }
    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println(time(linkedListStack, 200000) + "ms");
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        System.out.println(time(arrayStack,200000) + "ms");
        //基于链表的 new操作更多 基于数组的移动和扩容更多
        //他们之间没有复杂度的很大的差异。
    }
}
