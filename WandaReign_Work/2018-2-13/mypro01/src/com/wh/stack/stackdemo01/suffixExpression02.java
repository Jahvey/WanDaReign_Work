package com.wh.stack.stackdemo01;

import java.util.Arrays;

public class suffixExpression02 {


        private  static int stack2length = 0;

        // *****字符串与字符串数组的转换模块******
        public static char[] stringTransferChar(String input) {

            char[] inputchar;
            inputchar = input.toCharArray();
            return inputchar;
        }

        public static String[] getPoland(String input) {
            Stack stack1 = new Stack();
            Stack stack2 = new Stack();
            char[] inputchararray = stringTransferChar(input);

            stack1.push("#");
            Boolean pre = false;
            for (char chs : inputchararray) {
                // ***********************************************************HERE!!!**********
                if (chs >= '0' && chs <= '9') {
                    if (pre) {
                        int temp = Integer.valueOf(stack2.pop());
                        stack2.push(String.valueOf(temp * 10 + Integer.parseInt(chs + "")));
                        stack2length++;
                    } else {
                        stack2.push(String.valueOf(chs));
                        stack2length++;
                        pre = true;
                    }
                }

                switch (chs) {
                    case '(':
                        stack1.push(String.valueOf(chs));
                        pre = false;
                        break;
                    case ')':
                        while (!(stack1.peek().equals("("))) {
                            stack2.push(stack1.pop());
                            stack2length++;
                        }
                        stack1.pop();
                        pre = false;
                        break;
                    case '+':
                    case '-':
                        while (stack1.peek() != "#") {
                            if (stack1.peek().equals("(")) {
                                break;
                            } else {
                                stack2.push(stack1.pop());
                                stack2length++;
                            }
                        }
                        stack1.push(String.valueOf(chs));
                        pre = false;
                        break;
                    case '*':
                    case '/':
                        while (!(stack1.peek().equals("-")) && !(stack1.peek().equals("+")) && !(stack1.peek().equals("#"))) {
                            if (stack1.peek().equals("(")) {
                                break;
                            } else {
                                stack2.push(stack1.pop());
                                stack2length++;
                            }
                        }
                        stack1.push(String.valueOf(chs));
                        pre = false;
                        break;

                }

            }
            while (!stack1.isEmpty() && stack1.top.data != "#") {
                stack2.push(stack1.pop());
                stack2length++;
            }
            String[] chararrfromstack2 = new String[stack2length-1];
            int i = 0;
            while (!stack2.isEmpty()) {
                chararrfromstack2[i] = stack2.pop();
                i++;
            }

            return chararrfromstack2;
        }

        public static String getResUsePoland(String[] getcha){

            Stack stack = new Stack();
            int temx = 0;
            int temd = 0;
            int res = 0;
            String[] datas = new String[getcha.length];
            int k = getcha.length;
            System.out.println("*****"+k+"****");
            for(int i = 0;i<getcha.length;i++){
                datas[k-1] = getcha[i];
                k--;
            }
            System.out.println(datas[0]);
            for(int i = 0;i<datas.length;i++){
                if (isNum(datas[i])) {
                    stack.push(datas[i]);

                }else {
                    temx = Integer.valueOf(stack.pop());
                    temd = Integer.valueOf(stack.pop());
                    switch (datas[i]) {
                        case "+":
                            res = temx + temd;
                            break;
                        case "-":
                            res = temd - temx;
                            break;
                        case "*":
                            res = temd*temx;
                            break;
                        case "/":
                            res = temd/temx;
                            break;

                        default:
                            break;
                    }
                    stack.push(String.valueOf(res));
                }
            }
            return stack.pop();
        }

        public static boolean isNum(String str){
            for (int i = str.length();--i>=0;){
                if (!Character.isDigit(str.charAt(i))){
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            String input = "10-(7-3)*2";

            String[] getcha = suffixExpression02.getPoland(input);
            System.out.println("getcha length:"+getcha.length);
//            Arrays.stream(getcha).forEach(System.out::println);
//            Arrays.stream(getcha).forEach(System.out::print);
//            System.out.println();
            for (String ch : getcha) {
                System.out.print(ch+'\t');
            }
            System.out.println();
            String s = suffixExpression02.getResUsePoland(getcha);
            System.out.println("RES:"+s);
        }
    }

    class Stack {

        Node top = null;

        public Boolean isEmpty() {
            return top == null;
        }

        public int getLength(){


            return 0;
        }

        public void push(String data) {
            Node node = new Node(data);
            node.next = top;
            top = node;
        }

        public String peek() {
            if (top == null) {
                return null;
            }
            return top.data;
        }

        public String pop() {
            if (top == null) {
                return null;
            }
            Node tmp = top;
            top = top.next;
            return tmp.data;
        }

    }

    class Node {
        Node next;
        String data;

        public Node(String data) {
            this.data = data;
        }
    }

