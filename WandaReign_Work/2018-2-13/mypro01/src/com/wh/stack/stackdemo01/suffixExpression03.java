package com.wh.stack.stackdemo01;

import java.util.Stack;
import java.util.regex.Pattern;

public class suffixExpression03 {

       private static int statck2Len;//用于记录s2中的非空元素的个数
        /**
         * 栈s1用于存放运算符，
         * 栈s2用于存放逆波兰表达式
         *
         */
        private static Stack s1=new Stack();
        private  static  Stack<Object> s2=new Stack();




    /**
     * 得到对应字符串的相应的逆波兰表达式的字符串数组
     * @function 根据用户输入的字符串，转成相应的逆波兰表达式
     * @param input 用户输入的字符串
     * @return 返回表达式e的逆波兰式
     */
    public synchronized  static String[]getRPExpression(String input){
        char[]inputchararray=input.toCharArray();
        String []resultarray=null;
        //假设字符'@'是运算级别最低的运算符，并压入栈s1中
        s1.push('@');
        boolean preflag=false;
        for (char chs:inputchararray){//逐个扫描
            if (chs>='0'&&chs<='9'){
                if (preflag){
                    /**
                    Exception in thread "main" java.lang.ClassCastException: java.lang.Character cannot be cast to java.lang.Integer
                     at com.wh.stack.stackdemo01.suffixExpression03.getRPExpression(suffixExpression03.java:35)
                     at com.wh.stack.stackdemo01.suffixExpression03.main(suffixExpression03.java:199)
                     */
                    int temp=Integer.valueOf(s2.pop().toString());
                    s2.push(temp*10+chs);
                    statck2Len+=1;

                }else {
                    s2.push(chs);
                    statck2Len+=1;
                    preflag=true;
                }
            }

            switch (chs){
                case '('://遇'('则直接入栈s1
                    s1.push(chs);
                    preflag=false;
                    break;
                //遇')'则将距离栈s1栈顶的最近的'('之间的运算符，逐个出栈，依次送入栈s2,此时抛弃'('
                case ')':
                    while(!s1.peek().equals('(')){
                        s2.push(s1.pop());
                        statck2Len+=1;
                    }
                    s1.pop();
                    preflag=false;

                    break;

                //遇下列运算符，则分情况讨论：
     //1.若当前栈s1的栈顶元素是'('，则当前运算符直接压入栈s1；
       //2.否则，将当前运算符与栈s1的栈顶元素比较，若优先级较栈顶元素大，则直接压入栈s1中,
  //  否则将s1栈顶元素弹出，并压入栈s2中，直到栈顶运算符的优先级别低于当前运算符，然后再将当前运算符压入栈s1中

                case '+':
                case '-':
                    while(!s1.peek().equals('@')){
                        if (s1.peek().equals('(')){
                            break;
                        }else {
                            s2.push(s1.pop());
                            statck2Len+=1;
                        }

                        s1.push(chs);
                        preflag=false;
                    }

                    break;
                case '*':
                case '/':
                    while (!(s1.peek().equals('-')) && !(s1.peek().equals('+')) && !(s1.peek().equals('@'))) {
                        if (s1.peek().equals("(")) {
                            break;
                        } else {
                            s2.push(s1.pop());
                            statck2Len++;
                        }
                    }
                    s1.push(chs);
                    preflag= false;


                    break;
            }



        }

        //若栈s1非空，则将栈中的元素依此弹出并且将其压入栈s2中
        while(!s1.isEmpty()&&!s1.peek().equals('@')){
            s2.push(s1.pop());
            statck2Len++;
        }
        resultarray=new String [statck2Len-1];
        int index=0;
        while(!s2.isEmpty()){
            resultarray[index]=s2.pop().toString();
            index++;
        }


        return  resultarray;


    }

public   synchronized  static String getResults(String [] dataarray){
        Stack<Object> mystack=new Stack();
        Integer temx=0;
        Integer temy=0;
        double result= 0;
        String[]datas=new String[dataarray.length];
        int lens=dataarray.length;
    System.out.println("*******总长度为："+lens+"**********");
    for (int i = 0; i < dataarray.length; i++) {
        datas[lens-1]=dataarray[i];
        lens--;
    }
    System.out.print("开始计算时的数组：\n");
    for (int i = 0; i <datas.length; i++) {
            if (isInteger(datas[i])){
                mystack.push(datas[i]);
            }else {
                temx=Integer.valueOf(mystack.pop().toString());
                temy=Integer.valueOf(mystack.pop().toString());

                switch (datas[i]){
                    case "+":
                        result=temx+temy;
                        break;
                    case "-":
                        result =temx-temy;
                        break;

                    case "*":
                        result = temy*temx;
                        break;
                    case "/":
                        result = temx/temy;
                        break;

                    default:
                        break;

                }

                mystack.push(result);


            }

    }

    return (String) mystack.pop();


}



    public synchronized  static boolean isInteger(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public synchronized  static boolean isInteger2(String str){
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(str).matches();
    }

    @Deprecated
    public synchronized  static boolean isInteger1(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


public   static  synchronized  void show(String[] arr){
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]+"\t");
    }
    System.out.println();

}









    public static void main(String[] args) {

        String input = "10-(7-3)*2";

        String[] getcha = suffixExpression03.getRPExpression(input);
        for (String ch : getcha) {
            System.out.print(ch);
        }
        System.out.println();
        String s = suffixExpression03.getResults(getcha);
        System.out.println("RES:"+s);

    }

}
