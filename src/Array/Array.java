package Array;

public class Array<E> {
    private E[] data;
    private int size;//元素数量

    public Array() {
        this(10);
        size = 0;
    }

    public Array(int capacity) {
        data = (E[])new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向最后添加一个元素
    public void addLast(E e) {
       /* if(size == data.length) {
            throw new IllegalArgumentException("数组不够长");
        }
        data[size] = e;
        size++;*/
        //这里可以方法复用
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }



    //  添加一个元素
    public void add(int index, E e) {

        if (size == data.length) {
            resize(2 * data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("下标越界");
        }

        //需要挪的时候挪，不需要的时候下面直接赋值。挪了之后下面也要赋值
        for (int i = size - 1; i >= index; i--) {

            data[i + 1] = data[i];
        }
        size++;
        data[index] = e;
    }

    //获取index索引的位置
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("下标越界");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("下标越界");
        }
        data[index] = e;
    }

    //查找是否含有某元素
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //根据元素返回索引（第一次出现的索引）。
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }

        }
        return -1;
    }

    //删除元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("下标越界");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;

        data[size]=null;
        //多出来的没有用，让GC回收它。
        //Lazy的策略，满了扩容一倍。但是如果扩容后又进行了删除操作。（当size==data.length/2时就缩容）。这会立刻又缩容一半
        //resize方法调用的有点急了。使用懒的策略，当size==data.length/4时才缩容。就更好了。而且注意data.length为1的时候不要继续去缩容了。
        if(size==data.length/4 && data.length/2!=0){
            resize(data.length/2);
        }
        return ret;
    }

    //删除第一个元素
    public E removeFast() {
        return remove(0);
    }

    //删除第二个元素
    public E removeLast() {
        return remove(size - 1);
    }

    //如果有这个元素，删除
    public void removeElement(E e){
         int index = find(e);
         if(index!=-1){
             remove(index);
         }
    }

    public E getLast(){
        return  get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }
     //扩容的方法
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i]=data[i];
        }
        data = newData;

    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("数组元素的数量：" + size + "数组的容量：" + data.length);
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            //最后一个元素不用写逗号
            if (i != size - 1) {
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }
}
