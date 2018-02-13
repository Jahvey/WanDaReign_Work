package com.wh.day.tree02.BinaryTree1;
/**
 1、二叉树的先序创建
 2、二叉树的递归先序遍历
 3、二叉树的非递归先序遍历
 4、二叉树的递归中序遍历
 5、二叉树的非递归中序遍历
 6、二叉树的递归后序遍历
 7、二叉树的非递归后序遍历
 8、二叉树的层次遍历
 */

/**
 * 二叉树的结点的定义
 * @param <T>
 */
public class Node<T> {
    private T value;
    private Node<T>left;
    private Node<T>right;
    public Node(){}

    public Node( Node<T> left, Node<T> right,T value) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(T value) {
    this(null,null,value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
