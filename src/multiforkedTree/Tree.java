package multiforkedTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个节点出来，这个节点存id和数据，还有子节点的集合
 */
class Node {
    private Integer id;//节点id
    private String data;//节点数据
    public List<Node> nodeList = new ArrayList<>();//多个子节点利用集合实现

    public Node(Integer id) {
        this.id = id;
    }

    public Node(Integer id, String data) {
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

/**
 * 根节点不由用户创建，根节点默认的id为0，
 * index用来记录每一个添加节点的id，它自增。（节点的id为添加顺序 例如添加的第一个节点，它的id就是1，第二个就是2）
 */
public class Tree {
    private Node root = new Node(0);//根节点
    public int index = 1;//用于记录树上的点


    public Node getRoot() {
        return root;
    }

    /**
     * 添加方法，暴露给用户
     * 用户只关心添加给哪个父节点，添加的数据是什么
     * @param parentId 父节点
     * @param data 数据
     */
    public void add(int parentId,String data){
        //对于parentId为0 直接往根节点添加
        if(parentId == 0){
            Node newNode = new Node(index++,data);
            //根节点的nodeList应该添加这个节点
            root.nodeList.add(newNode);
        }else{
            //否则去调用真正的添加方法
            add(parentId,data,root.nodeList);
        }

    }

    private void add(Integer parentId,String data,List<Node> nodeList){


            for (Node node : nodeList) {
                //如果这个节点的id是用户传入的父节点，则将这个节点插入的这个节点下。
                if(node.getId() == parentId){
                    Node newNode = new Node(index++,data);
                    node.nodeList.add(newNode);
                    return;
                }
                //递归遍历节点集合
                add(parentId,data,node.nodeList);

           }
    }

    //深度优先
    public void dfsList(){
        dfsList(root.nodeList);
    }

    /**
     * 深度优先 只要对一个节点一直往里找就行了。使用递归。
     * @param list 这个集合第一次传进来的是根节点的子节点们，下一次就是子节点的子节点们了。
     */
    private void dfsList(List<Node> list){
        for (Node node : list) {
            System.out.println(node.getData());
            dfsList(node.nodeList);
        }
    }

    public void bfsList(){
        bfsList(root.nodeList);
    }

    /**
     * 广度优先  我们先要把这个节点的所有子节点的数据找到，在把这些子节点存起来，之后对子节点去递归。
     *
     * @param nodeList
     */
    private void bfsList(List<Node> nodeList){
        //创建一个集合用于存储节点
        List<Node> arrayList = new ArrayList();
        //遍历一个集合里所有节点，将节点的数据都输出来，之后将这些节点都存起来。
        for (Node node : nodeList) {
            System.out.println(node.getData());
            arrayList.add(node);
        }
        //对存起来的节点，遍历出来去对他们的子节点递归广度优先遍历
        for (Node node : arrayList) {
            bfsList(node.nodeList);
        }
    }


}
