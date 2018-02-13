package com.wh.day.tree03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * http://www.cnblogs.com/LZYY/p/3454778.html
 */

public class BTreeDemo{
    //递归实现二叉树的前序遍历
    public static void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //非递归实现前序遍历
    public static ArrayList preOrder1(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList alist = new ArrayList();
        TreeNode p = root;
        while(p != null || !stack.empty()){
            while(p != null){
                alist.add(p.val);
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                TreeNode temp = stack.pop();
                p = temp.right;
            }
        }
        return alist;
    }

    //递归实现中序遍历
    public static void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
    //非递归实现中序遍历
    public static ArrayList inOrder1(TreeNode root){
        ArrayList alist = new ArrayList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || !stack.empty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                TreeNode temp = stack.pop();
                alist.add(temp.val);
                p = temp.right;
            }
        }
        return alist;
    }
    //递归实现二叉树的后序遍历
    public static void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }
    //非递归实现二叉树的后续遍历
    public static ArrayList postOrder1(TreeNode root){
        ArrayList alist = new ArrayList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null)
            return alist;
        TreeNode cur,pre = null;
        stack.push(root);
        while(!stack.empty()){
            cur = stack.peek();
            if((cur.left == null && cur.right == null) || //
                    (pre != null && (cur.left == pre || //
                            cur.right == pre))){
                TreeNode temp = stack.pop();
                alist.add(temp.val);
                pre = temp;
            }
            else{
                if(cur.right != null)
                    stack.push(cur.right);
                if(cur.left != null)
                    stack.push(cur.left);
            }
        }
        return alist;
    }
    //非递归实现二叉树的层次遍历
    private static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp  = queue.poll();
            System.out.print(temp.val + " ");
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
    }

    //简单创建一个简单的二叉树
    public static TreeNode createBT(){
        TreeNode i = new TreeNode("I");
        TreeNode h = new TreeNode("H");
        TreeNode g = new TreeNode("G");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F", h, i);
        TreeNode d = new TreeNode("D", null, g);
        TreeNode c = new TreeNode("C", f, null);
        TreeNode b = new TreeNode("B", d, e);
        TreeNode root = new TreeNode("A", b, c);
        return root;
    }

    public static void main(String[] args) {
        //简单创建普通二叉树
        TreeNode root = createBT();
        //递归实现前序遍历
        System.out.println("递归实现前序遍历");
        preOrder(root);
        System.out.println();
        System.out.print("非递归实现前序遍历");
        System.out.println();
        //非递归实现前序遍历
        for(Object o : preOrder1(root)){
            System.out.print(o.toString() + " ");
        }
        System.out.println();
        System.out.println("********************************");
        //递归实现中序遍历
        System.out.println("递归实现中序遍历");
        inOrder(root);
        System.out.println();
        System.out.print("非递归实现中序遍历");
        System.out.println();
        for(Object o : inOrder1(root)){
            System.out.print(o.toString() + " ");
        }
        System.out.println();
        System.out.println("********************************");
        //递归实现后序遍历
        System.out.println("递归实现后序遍历");
        postOrder(root);
        System.out.println();
        System.out.print("非递归实现后序遍历");
        System.out.println();
        //非递归实现后续遍历
        for(Object a : postOrder1(root)){
            System.out.print(a.toString() + " ");
        }
        System.out.println();
        System.out.println("********************************");
        //非递归实现层次遍历
        System.out.println("非递归实现层次遍历");
        levelOrder(root);
    }
}
