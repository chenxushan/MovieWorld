##刷题笔记

java中如果两个hashMap的key和value都逐一相等，则map1.equals(map2) 为true
```java
     public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Map))
            return false;
        Map<?,?> m = (Map<?,?>) o;
        if (m.size() != size())
            return false;
        try {
            Iterator<Entry<K,V>> i = entrySet().iterator();
            while (i.hasNext()) {
                Entry<K,V> e = i.next();
                K key = e.getKey();
                V value = e.getValue();
                if (value == null) {
                    if (!(m.get(key)==null && m.containsKey(key)))
                        return false;
                } else {
                    if (!value.equals(m.get(key)))
                        return false;
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
        return true;
    }

```

求int[]中的最大值
```java
import java.util.Arrays;
import java.util.Collections;

public static int MAX(int[] arr) {
    Arrays.sort(arr);
    return arr[arr.length-1];
}

public static void main(String[] args) {
    Integer[] numbers = { 8, 2, 7, 1, 4, 9, 5};
    int min = (int) Collections.min(Arrays.asList(numbers));
    int max = (int) Collections.max(Arrays.asList(numbers));
    System.out.println("最小值: " + min);
    System.out.println("最大值: " + max);
}

public static int MAX(int[] arr) {
    return Arrays.Stream(arr).max().getAsInt();
}

```