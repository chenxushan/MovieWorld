package com.mobius;

import java.util.*;

public class Common {

    public Comparator<Integer> getComparable() {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //升序
                return o1-o2;
                //降序
                //return o2-o1;
            }
        };
        return cmp;
    }

    public void StringUse() {
        String s= "asdefgasdefg";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
        }
        s.indexOf('s');
        s.indexOf('s',2);
        s.lastIndexOf('s');
        s.lastIndexOf('s',6);
        String[] ss = s.split("regex");
        //String s = s.substring(int start,int end);
        char[] cs = s.toCharArray();
        String s1 = s.toLowerCase();//将字符串转换为小写
        String s2 = s.toUpperCase();//将字符串转换为大写
        String s3 = s.trim();
        //String s4 = String.valueOf(object);

        //数组排序
        //Arrays.sort();//n*log(n);//重载了四个方法
//        sort(T[] a);
//        sort(T[] a,int fromIndex,int toIndex);//按升序排列数组的指定范围。
//        sort(T[] a,Comparator<? super T> c);//根据指定比较器产生的顺序对指定对象数组进行排序。
//        sort(T[] a,int fromIndex,int toIndex,Comparator<? super T> c);//根据指定比较器产生的顺序对指定对象数组的指定对象数组进行排序。


    }

    public void mapUse(){
        HashMap<Character,Integer> map=new HashMap<>();
//HashMap tranversal:
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            System.out.println(key + " " + val);
        }
//        Arrays.hashCode(arr);//get the hash of an arr(unique)
////use an array to represent hashmap:
//        int[] tmp = new int[26];
//        for (char ch: tmp.toCharArray()) {
//            tmp[ch - 'a']++;
//        }
    }

    public void treeUse() {
        class TreeCompare implements Comparator<String>
        {
            /* Compares keys based on the
               last word's natural ordering */
            public int compare(String a, String b)
            {
                return a.compareToIgnoreCase(b);
            }
        }
        TreeMap<String, Double> tm = new TreeMap<>(new TreeCompare());
//        tm.containsKey(Object key);
//        tm.containsValue(Object value);
//        tm.fistKey();//return the lowest key currently in map
//        tm.lastKey();//get the last key in sorted map
//        tm.remove(Object key);
    }

    public void arrayUse() {
        //Arrays.fill(dp,0);


        int[][]A={
                {4,3,4,5,3},
                {2,7,3,8,4},
                {1,7,6,5,2},
                {8,4,9,5,5}
        };

        int a = 0;
        int b = 1;
        int[] tmp = new int[]{a, b};

//        public static <T> T[] copyOfRange(T[] original,
//        int from,
//        int to)

        //System.arraycopy(T[] source, int sourcePos,T[] dest_arr, int destPos, int len)

        //System.out.println(Arrays.toString(arr));
        //这里要注意：不能直接 arr.toString()


    }
}
