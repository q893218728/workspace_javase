package Array;

public class Test {


    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>();
        for (int i = 0; i < 6; i++) {
            arr.add(i,i);
        }
        System.out.println(arr);
        arr.remove(1);

        System.out.println(arr);
        byte b1 = 127;
        byte b2 = 127;
         byte b3 = (byte) (b2 + b1);
        System.out.println(b3);

       /* System.out.println(arr);
        arr.add(2,100);
        System.out.println(arr);
         arr.add(0,20);
        System.out.println(arr);

        arr.remove(0);
        System.out.println(arr.contains(6));
        System.out.println(arr);*/

    }
}
