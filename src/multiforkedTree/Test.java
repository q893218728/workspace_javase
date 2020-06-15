package multiforkedTree;

public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(0, "1"); //id1
        tree.add(0, "2");//2
        tree.add(0, "3");//3
        tree.add(1, "11");//4
        tree.add(1,"12");//5
        tree.add(1,"13");//6
        tree.add(0,"4");//7
        tree.add(2,"21");//8
        tree.add(8,"211");//9
        tree.add(7,"41"); //10
        tree.add(12,"123");
        tree.add(5,"121");
        tree.add(5,"122");
        tree.add(11,"1211");
        System.out.println("深度优先遍历结果");
        tree.dfsList();
        System.out.println("=======");
        System.out.println("广度优先遍历结果");
        tree.bfsList();
    }
}
