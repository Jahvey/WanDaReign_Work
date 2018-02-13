package com.wh.day012;

/**
 * java是面向对象的语言，核心思想：找适合的对象做适合的事情：
 * 方式1：自定义类，然后通过自定义的类创建对象
 * 方式2：sun提供了很多类可以给我们使用，然后我们就可以通过这些类来创建对象
object是所有类的终极父类。
常用的方法
 toString() 返回该对象的字符串表示
 equals(Object obj)
 hashCode()

 */
public class ObjectDemo1 {




    public static void main(String[] args) {
        Demo01 demo01=new Demo01();
        System.out.println("toString:"+demo01.toString());
        System.out.println("hashCode:"+demo01.hashCode());
    }
}
