package com.mobius.oj;

public class numCovert {

    public static void main(String[] args) {
        System.out.println(getNumOneCount1(3));
    }

    private static int getNumOneCount1(int i) {
        int count = 0;
        while (i != 0) {
            if ((i & 1) == 1) {
                count++;
            }
            i = i >> 1;
        }
        return count;
    }

    private static int getNumOneCount2(int i) {
        int count=0;
        while (i!=0){
            i=i&(i-1);
            count++;
        }
        return count;
    }

    private static int getNumOneCount3(int i) {
        int count=0;
        String str=Integer.toBinaryString(i);
        for (int j = 0; j <str.length() ; j++) {
            if(str.charAt(j)=='1'){
                count++;
            }
        }
        return count;
    }
}
