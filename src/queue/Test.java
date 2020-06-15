package queue;

public class Test {
    public static void main(String[] args) {
        /*ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);//向队尾添加
        }
        System.out.println(queue);
        queue.dequeue();//弹出队首
        System.out.println(queue);*/

        //创建的数组是用户穿进去的+1. 返回来的数组容量是数组长度-1
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 20; i++) {
            loopQueue.enqueue(i);//向队尾添加
        }
        System.out.println(loopQueue);
        loopQueue.dequeue();//弹出队首
        System.out.println(loopQueue);
        //System.out.println(loopQueue.dequeue());
    }
}
