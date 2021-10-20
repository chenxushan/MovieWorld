package com.mobius.struct;

//1、整数能否直接赋值给char
//        2、char x = 97;
//        这个Java语句是允许的，并且输出的结果是'a'
//        经过这个测试得出两个结论：
//        第一个结论：当一个整数赋值给char类型变量的时候，会自动转换成char字符型，
//        最终的结果是一个字符。
//
//        第二个结论：当一个整数没有超出byte short char 的取值范围的时候，
//        这个整数可以直接赋值给byte short char 类型的变量。

public class CharCase {
    public static void main(String[] args) {
        char m='a'+1;
        System.out.println(m);

        int a = 'a';
        int A = 'A';
        System.out.println(a+","+A);

        int value='a'+'b';
        System.out.println(value);

        char c1 = 'a';
        System.out.println(c1);

        // 这里会做类型转换吗？
        // 97是int类型（这是java中规定的）
        char c2 = 97;
        System.out.println(c2); // 'a'

        // char类型的取值范围：[0 ~ 65535]
        char c3 = 65535;
        System.out.println(c3);

        System.out.println(Character.isDigit('a'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.toLowerCase('A'));
        System.out.println(Character.toUpperCase('a'));

        // 字符数组
        char[] charArray ={ 'a', 'b', 'c', 'd', 'e' };
        Character ch = new Character('a');
    }
}
