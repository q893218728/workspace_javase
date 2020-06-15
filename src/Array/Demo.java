package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 30个数随机分成x组
 *
 */
public class Demo {

    /**
     * 建立一个集合，集合中存的是x个Array数组
     * 随机生成0到x-1的整数，生成的是几 就往集合的这个下标的数组中添加一个数据（30个数之一）
     * @param arr
     * @param x
     * @return
     */
    public static List<Array> distribution(int[] arr,int x){
        List<Array> arrayList = new ArrayList<Array>(x);

        for (int i = 0; i < x; i++) {
            Array array = new Array();
            arrayList.add(array);
        }
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
           int temp =  random.nextInt(x);
           arrayList.get(temp).addLast(arr[i]);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] arr = new int[30];
        for (int i = 0; i <30 ; i++) {
            arr[i]=i+1;

        }
        List<Array> arrayList = distribution(arr,5);
        for (Array array : arrayList) {
            System.out.println(array);
        }

    }
}
