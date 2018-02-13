package com.wh.day.tree01;

import java.util.Stack;

public class Tree {
    private  Node root;

    public Tree() {
        this.root = null;
    }
public void insert(int key,double value){
        Node newNode=new Node();
        newNode.iKey=key;
        newNode.iValue=value;
        if (root==null){//tree is Empty
            root=newNode;
        }else {
            Node current=root;
            Node parent;
            while(true){
                parent=current;
                if (key<current.iKey){//如果要插入的数据key小于当前的数据项的话
                    current=current.leftChild;//更新current
                    if (current==null){
                        parent.leftChild=newNode;
                        return;
                    }
                }else {//如果要插入的数据key,大于或者等于当前的数据项，则往右边找
                    current=current.rightChild;
                    if (current==null){
                        parent.rightChild=newNode;
                        return;
                    }
                }
            }
        }

}

    /**
     * 删除的时候需要注意的几点：
     * 1.如果要删除的节点的右子节点不为空.(current.rightChild!=null)
     * 1.1删除的是parent.rightChild(父节点的右子节点),或者是
     * parent.leftChild(父节点的左子节点)，则都可以将current节点的
     * 右子树的最左边的子节点移动到current节点的位置上。
     *
     * 2.如果要删除的节点的右子节点为空(current.rightChild==null)
     * 则直接将current=current.leftChild,即直接将要删除的节点的左
     * 子节点替换掉current节点的位置，即可。
     *
     * @param key
     * @return
     */
        public  boolean delete(int key){
            Node current=root;
            Node parent=root;//需要父节点作为判断的依据
            boolean isLeftChild=true;//添加这个数据项的目的是为了判断current和parent的左右子树关系

            //如果跳出这个while循环，则找到了，可以删除该节点
            while(current.iKey!=key){
                parent=current;//先保存一份数据到parent中
                if (key<current.iKey){
                    //如果要查找的值小于当前节点的值，则往左找，修改isLeftChild的值
                    isLeftChild=true;//修改标签，确定是往parent=current的左边找，同时更新parent的值
                    current=current.leftChild;
                }else {
                    //往右边搜索，不存在key==current.iKey的情况，因为while条件的限定，就会直接跳出while循环，
                    //，执行delete操作
                    isLeftChild=false;
                    current=current.rightChild;
                }

                //如果没找到，即current==null,直接return false
                if (current==null)return  false;//没有找到要删除的数据项，或者是节点

            }

            //由于程序的执行顺序，跳出while循环，则一定表示找到了对应的数据项所对应的节点

            /**
             * 现在进入删除的几种情况：
             * 1.要删除的节点是叶子节点
             * 1.1如果要删除的节点恰好是根节点，则root=null;
             * 1.2如果要删除的叶子节点是父节点的左节点，则将父节点的左子节点置为Null
             * 1.3如果要删除的叶子节点是父节点的右子节点，则将父节点的右子节点置为null
             *
             * 2.如果要删除的节点的右子节点为null
             * 2.1如果要删除的节点恰好是根节点，则root=current.leftChild
             *2.2如果要删除的节点是该节点父节点的左子节点，则将该父节点的左子节点的指针
             * 指向当前节点的左子节点
             * 2.3 如果要删除的节点是该节点的父节点的右子节点，则将该父节点的右子节点
             * 的指针指向当前节点的左子节点
             *
             *
             * 3.如果要删除的节点的左子节点为null
             * 3.1如果要删除的节点恰好是根节点，则root=current.rightChild
             * 3.2如果要删除的节点是父节点的左子节点，则将父节点的左子节点的指针指向
             * 当前节点的右子节点
             * parent.leftChild=current.rightChild;
             * 3.3如果要删除的节点是父节点的右子节点，则将父节点的右子节点的指针指向
             * 当前节点的右子节点
             * parent.rightChild=current.rightChild;
             *
             *
             * 4.要删除的节点，左右两个子树都有
             *
             *
             *
             */
            //要删除的节点是叶子节点，直接删除
            if (current.leftChild==null&&current.rightChild==null){
                    if (current==null)root=null;//删除的是根节点，并且没有子节点
                     else if(isLeftChild){//删除的叶子节点是父节点的左子节点，则将父节点的左子节点置为Null
                        parent.leftChild=null;
                    }else {
                         //要删除的叶子节点是父节点的右子节点，则将该叶子节点的的父节点的右子节点置为null
                        parent.rightChild=null;
                    }
            }else  if(current.rightChild==null){
                //表明要删除的节点只有一个左子节点

                /**
                 * 要删除的节点只有一个左子节点
                 * 3种情况：
                 * 1.要删除的节点恰好是root节点，则root=current.leftChild
                 * 2.要删除的节点是当前节点父节点的左子节点，则将父节点的左子节点的指针指向
                 * 当前节点的左子节点 parent.leftChild=current.leftChild;
                 * 3.要删除的节点是当前节点父节点的右子节点，则将父节点的右子节点的指针指向
                 * 当前节点的左子节点（你没有看错！）
                 * parent.rightChild=current.leftChild;
                 *
                 *
                 */
                if(current==root)root=current.leftChild;
                else if(isLeftChild)parent.leftChild=current.leftChild;
                else parent.rightChild=current.leftChild;

            }else  if (current.leftChild==null){
                //要删除的节点只有一个右子节点
                if (current==root)root=current.rightChild;
                else  if (isLeftChild)parent.leftChild=current.rightChild;
                else parent.rightChild=current.rightChild;


            }else {
                //要删除的节点有两个子节点
                //调用getSuccessor(要删除的节点(while找到的current节点))
                Node successor=getSuccessor(current);
                //if ()
                if (current==root)root=successor;
                else if (isLeftChild)parent.leftChild=successor;
                else parent.rightChild=successor;

                //最后需要考虑到successor的左孩子,跟要删除的current的左孩子相关联
                successor.leftChild=current.leftChild;
            }
            return true;


        }


    /**
     * 则需要使用调用该方法获取要删除的节点的右子树的最左边的叶子节点，
     * 将其挪到要删除的current节点的位置上，则该方法需要传入要删除的
     * 节点的引用
     *向右子节点向下找继承者节点
     * @param delNode
     * @return
     */
        private  Node getSuccessor(Node delNode){
                //申明一个successor的原父节点
            //作用：便于修改指针引用，因为(successor.parent.leftChild=successParent)=null;才行
                Node successorParent=delNode;
               Node successor=delNode;
               // Node successor=delNode.rightChild;//指向要删除的节点的右子树的树根，进行迭代查找

                Node current=delNode.rightChild;//声明要查找的节点的临时变量
                //开始搜索,初始化搜索参数,当while循环结束的时候，表明找到了
            //要删除的节点的右子树，的最左边下面的叶子节点，才能跳出循环
                while(current!=null){
                    successorParent=successor;
                    successor=current;
                    //注意，这次是查找current左子节点的最下面的叶子节点
                    current=current.leftChild;
                }

                //进入到该行代码，表明已经跳出了while循环。
            // 并且找到了要删除的节点的右子树的最左边下面的叶子节点

            /**
             * 这里有种情况是如下所示；
             * 看着篇博客里面的几种情况
             * http://blog.csdn.net/wuwenxiang91322/article/details/12231657
             * 1.       root
             *         /     \
             *        a       b
             *      /  \
             *     c   d
             *        /  \
             *     null   e
             *  如图所示，如果要删除a节点，则根据以上的算法，就会successor的指针指向d
             *  此时，successor==delNode.rightChild如果要删除a节点，则只需要将d移动
             *  到a处即可。但是如果是如下情况：
             * 2.
             *          root
             *         /     \
             *        a       b
             *      /  \
             *     c   d
             *        /  \
             *       e    f
             *      /  \
             *     null g
             *
             *   则根据上面的算法，successor指向的节点是e,而delNode.rightChild为d
             *  successor!=delNode.rightChild,故还得将
             *  successorParent.leftChild=successor.rightChild;
             *  successor.rightChild=delNode.rightChild;
             *  即如图所示：
             *           root
             *         /     \
             *        e       b
             *      /  \
             *     c   d
             *        /  \
             *       g    f
             *则删除才算完成
             *
             */
            if (successor!=delNode.rightChild){
                   successorParent.leftChild=successor.rightChild;
                   successor.rightChild=delNode.rightChild;
            }
            return successor;

        }

    /**
     * 选择要查找的节点
     * @param key
     * @return
     */
    public Node find(int key){
        Node current=root;
        while (current.iKey!=key){
            if (key<current.iKey){
                current=current.leftChild;
            }else {
                current=current.rightChild;
            }
            //注意：这是必须的，要在while循环里面处理找不到的情况

            if (current==null)return null;

        }

        //代码若正确执行到这行，表示正确找到了要查找的节点
        return  current;


    }


    /**
     * 遍历方法类型
     * @param traverseType
     */
    public void traverse(int traverseType){
        switch (traverseType){
            case 1://从上至下，从左至右
                System.out.print("\nPreorder traversal:");
                PreOrder(root);
                break;
            case 2://从下至上，从左至右
                System.out.print("\nInorder traversal:");
                InOrder(root );
                break;
            case 3://从下至上，从右至左（从大到小
                System.out.print("\nPostorder traversal:");
                postOrder(root);
                break;

        }
        System.out.println();




    }


    private  void PreOrder(Node localRoot){
        //从上到下，从左到右的遍历
        if (localRoot!=null){
            System.out.print(localRoot.iKey+" ");
            PreOrder(localRoot.leftChild);
            PreOrder(localRoot.rightChild);
        }


    }


    private void InOrder(Node localRoot){

        //从下至上，从左至右（从小到大）
        if (localRoot!=null){
            InOrder(localRoot.leftChild);
            System.out.print(localRoot.iKey+" ");
            InOrder(localRoot.rightChild);
        }

    }

    private  void postOrder(Node localRoot){
        //从下至上，从右至左（从大到小

        if (localRoot!=null){
            postOrder(localRoot.rightChild);
            postOrder(localRoot.leftChild);
            System.out.print(localRoot.iKey+" ");
        }
    }


    /**
     * 使用树形结构显示
     */
    public void displayTree(){
        Stack globalStack=new Stack();
        globalStack.push(root);
       // int nBlank=32;
        int nBlank=32;
        boolean isRowEmpty=false;
        String dot="............................";
        System.out.println(dot+dot+dot);
        while (isRowEmpty==false){
            Stack localStack=new Stack();
            isRowEmpty=true;
            for (int j=0;j<nBlank;j++)//{
            {

                System.out.print("-");
            }
            while (globalStack.isEmpty()==false){
                //里面的while循环用于查看全局的栈是否为空
                Node temp=(Node)globalStack.pop();
                if (temp!=null){
                    System.out.print(temp.iKey);

                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    //如果当前的节点下面还有子节点，则必须要进行下一层的循环
                    if (temp.leftChild!=null||temp.rightChild!=null){
                        isRowEmpty=false;

                    }
                }else {
                    //如果全局的栈则不为空
                    System.out.print("#!");
                    localStack.push(null);
                    localStack.push(null);

                }


                //打印一些空格
                for (int j=0;j<nBlank*2-2;j++){
                    //System.out.print("&");
                    System.out.print(" ");
                }




            }//while end


            System.out.println();
            nBlank/=2;
            //这个while循环用来判断，local栈是否为空,不为空的话，则取出来放入全局栈中
            while (localStack.isEmpty()==false){
                globalStack.push(localStack.pop());
            }

            // }
        }//大while循环结束之后，输出换行
        System.out.println(dot+dot+dot);

    }





}
