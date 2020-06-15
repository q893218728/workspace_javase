package Stack;

import java.util.Stack;

public class Test1 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    /*public void push(int node){
       stack1.push(node);
    }

    public int pop(){
        int tmp = 0;
        for (Integer integer : stack1) {
            tmp =  integer;
            stack1.remove(integer);
            break;
        }

        return tmp;
    }*/

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
       if(stack2.isEmpty()){
           while (!stack1.isEmpty()){
               stack2.push(stack1.pop());
           }

       }
       return stack2.pop();
    }
    public static void main(String[] args) {
         Test1 t = new Test1();
         t.push(1);
        t.push(2);
        t.push(1);
        t.push(4);
        t.push(5);
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
        t.push(5);
        System.out.println(t.pop());

    }
}
