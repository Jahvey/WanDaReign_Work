package com.wh.stack.stackdemo01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * 后缀表达式本身的实现
 * 后缀表达式求值
 *1.中缀表达式转后缀表达式（利用栈扫描整个表达式，找出最高的优先级，这样后缀表达式
 * 演算的时候不需要考虑优先级的问题）
 * 表达式 "9+(3-1)*3+10/2"转化为后缀表达式“931-*+【10】 2 /+”
**数字输出，运算符进栈，括号匹配出栈，栈顶优先级低出栈


 */
public class suffixExpression01 {



    public String [] getArrs(String target){
        String []temps=target.split("[*()/+-]+");
        List<String> mylist=new LinkedList();




        String[]results= (String[]) mylist.toArray();



        return results ;
    }

    /**
     * 承接一个带有字符串数组的，返回一个String对象
     * @param arr
     * @return
     */
    public String getSuffixExpre02(String[]arr){
        StringBuffer sb=new StringBuffer();
        Stack mystack=new Stack();



        return  sb.toString();

    }




    /**
     * 9+(3-1)*3+10/2转成后缀表达式
     * “931-*+【10】 2 /+”
     * @param value
     * @return
     */
    public String getSuffixExpre01(String value){
        StringBuffer sb=new StringBuffer();
        Stack stack=new Stack();
        String[] temps=value.split("[*()/+-]+");
        List<Object> list=Arrays.asList(temps);
        while(list.size()>=0){
            if (value.contains(list.get(0).toString())){
                int index=value.indexOf(list.get(0).toString());
                sb.append(list.get(0));
                String  flag=String.valueOf(value.charAt(index+1));
                stack.push(flag);
                if (value.contains("(")){

                }else{
                    if (flag.equals("*")||flag.equals("/")){

                        if (stack.peek()!=null&&(stack.peek().equals("+")||stack.peek().equals("-"))){

                        }
                    }
                }
                list.remove(list.get(0));

            }
        }

        return  sb.toString();

    }

    public static void main(String[] args) {
        String[] temps="9+(3-1)*3+10/2".split("[*()/+-]+");
        System.out.println(Arrays.asList(temps));
       // Arrays.stream(temps).filter(s -> s!=null).forEach(System.out::println);
        //temps=null;
        //temps= (String[]) Arrays.stream(temps).filter(s -> !s.equals("")).toArray();
        //System.out.println(Arrays.stream(temps).filter(s -> !s.equals("")).toString());
        //Arrays.stream(temps).filter(s -> !s.equals("")).forEach(System.out::println);

        //System.out.println(Arrays.stream(temps).filter(s -> s!=" "));
    }






}
