package com.wh.day.tree01;

/**
 * 创建一个二叉树的节点
 */
public class Node {
    public int iKey;
    public double iValue;
    public Node leftChild;
    public Node rightChild;

    /**
     * 将该节点的详细信息打印出来
     */
    public void show(){
        System.out.print('[');
        System.out.print("iKey = " + iKey);
        System.out.print(',');
        System.out.print("iValue = " + iValue);
        System.out.print(']');
    }
    


}
