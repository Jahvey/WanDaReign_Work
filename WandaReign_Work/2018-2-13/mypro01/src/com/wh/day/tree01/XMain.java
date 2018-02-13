package com.wh.day.tree01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XMain {
    public  static String getString()throws Exception{

        InputStreamReader isr= new InputStreamReader(System.in);

        BufferedReader br=new BufferedReader(isr);
        return br.readLine();


    }

    public  static  char getChar()throws  Exception{
        return getString().charAt(0);
    }

    public static  int getInt()throws Exception {
        return Integer.parseInt(getString());
    }

    public static void main(String[] args)throws  Exception {

        int value;

        Tree the=new Tree();
        the.insert(50,1.5);
        the.insert(25,1.2);
        the.insert(75,1.7);
        the.insert(12,1.5);
        the.insert(37,1.2);
        the.insert(43,1.7);
        the.insert(30,1.5);

        the.insert(33,1.2);
        the.insert(87,1.7);
        the.insert(93,1.5);
        the.insert(97,1.5);


        while (true){
            System.out.print("Enter first letter of show,insert,find,delete or traversal");

            int choice=getChar();
            switch (choice){
                case 's'://显示
                    the.displayTree();
                    break;
                case 'i'://插入
                    System.out.print("Enter the value of insert：");
                    value=getInt();
                    the.insert(value,value+0.9);
                    break;

                case 'f'://查找

                    System.out.print("Enter value to find:");
                    value=getInt();
                    Node found=the.find(value);
                    if (found!=null){
                        System.out.print("Fount:");
                        found.show();
                        System.out.println();
                    }else {
                        System.out.print("Sorry,We don't find "+value+".");
                        System.out.println();
                    }

                    break;
                case 'd'://删除
                    System.out.print("Enter value to delete:");
                    value=getInt();
                    boolean didDelete=the.delete(value);

                    if (didDelete) System.out.print(value+"has been deleted!!"+"\n");
                    else System.out.print("Could not delete"+value+"!!No find "+value+".\n");
                    break;

                case 't'://遍历
                    System.out.print("Enter type 1,2 or 3:");
                    value=getInt();
                    the.traverse(value);
                    break;
                default:
                    System.out.println("Invalid entry!\n");
            }


        }

    }
}
