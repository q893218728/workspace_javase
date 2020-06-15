package queue;

import java.util.ArrayDeque;

/**
 * 用来比较ArrayQueue和LoopQueue的效率
 * 循环队列的效率远远高于ArrrayQueue
 * 主要差距在出队的时候因为每弹出一个 剩下的全部都要前挪一位。
 * 弹出O（n）复杂度 整个方法的复杂度是O(n2）
 * 对于循环队列
 * 弹出O1的复杂度。添加是O1的复杂度 整个方法的复杂度是O(n);
 * 对于LinkedLisQueue，
 * 弹出队首O1的复杂度，添加在队首添加，也是O1的复杂度 整个time方法的复杂度On 所以和循环队列差不多
 */
public class Main {
    public static double time(Queue<Integer> queue, Integer opCount){
        double startTime = System.currentTimeMillis();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        double endTime = System.currentTimeMillis();
        return (endTime-startTime)/1000;
    }

    public static void main(String[] args) {
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("ArrayQueue  " + time(arrayQueue, 100000) + "S");
        Queue<Integer> loopQueue = new LoopQueue<>();
        System.out.println("LoopQueue  " +time(loopQueue,100000)+ "S");
        /*ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        System.out.println(time(arrayDeque,100000));*/
        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println("LinkedListQueue  " +time(linkedListQueue, 100000) + "S");
    }
}
