package com.wh.day.tree02.file;

public class Test1 {
    /**
     * if(nStatus & (0x1 << (i+1)) == 0
     就是nStatus用二进制表示，从低位数起第i+1位（从第0开始）是否为0的意思。
     例如nStatus是21，i是3，
     21(d)的二进制是10101(b),
     0x1<<(3+1)，将1左移4位成10000(b)
     10101&10000==10000！=0
     从而知道第4位不是0。
     */
    public static void TestLongLength(){
        //if((i & 0x1) == 1)//判断编号为奇数
        String string="1111111111111111112";//Long类型长度最多支持19位的整数
        System.out.println(string.length()+" "+((Long.parseLong(string)&0x1)==1));
    }
    public static void main(String[] args) {
        TestLongLength();
    }

}
