package queue;

/**
 * 动态队列
 * 因为有一个空间浪费。我们创建的数组的长度是传进来的容量+1
 * 我们返回出去的容量，应该返回数组的长度-1
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;//指向队首
    private int tail; //指向队尾的后一位
    private int size;//元素数量

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];//因为要浪费一个，所以实际大小是用户传入的大小+1
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;//因为有浪费 所以返回数组的长度-1
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        //如果满了
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }



    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        E ret = data[front];
        data[front] = null;
        size--;
        front =(front+1)%data.length;
        //判断是否要缩容
        if(size==getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);//缩容
        }
        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];//注意索引的偏移
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: size:" + size + " capacity:" + getCapacity());
        res.append("队首[");
        for (int i = front; i != tail; i=(i+1)%data.length) {
            res.append(data[i]);
            //最后一个元素不用写逗号
            if ((i+1)%data.length != tail) {
                res.append(',');
            }
        }
        res.append("]队尾");
        return res.toString();

    }
}
