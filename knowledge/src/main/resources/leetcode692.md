###
参考连接：
- https://codeleading.com/article/82862461517/
- https://www.cnblogs.com/blogtech/p/11162567.html
- https://www.huaweicloud.com/articles/8359632.html
- https://segmentfault.com/a/1190000017807395
- https://www.jianshu.com/p/81e5c3e88fc6
- https://www.runoob.com/java/java-string-compareto.html
- https://blog.csdn.net/yaomingyang/article/details/78748130
- http://www.cxyzjd.com/article/fangfeng1021/108285955
- https://juejin.cn/post/6844903869332324365
- https://mp.weixin.qq.com/s?__biz=MzIwNTc4NTEwOQ==&mid=2247486030&idx=1&sn=a5b2d98f595ad049f0b55cdefb930365&chksm=972adb34a05d522270879c2bf7990a25b7433d738ce5f52f23a3e48b53f74c73be8075e7e148&scene=0&subscene=131&ascene=7&devicetype=android-26&version=26070334&nettype=WIFI&abtest_cookie=BAABAAoACwANABMABAAllx4AV5keAICZHgCJmR4AAAA%3D&lang=zh_CN&pass_ticket=Z8SghZSiaU7M1Wgtfag%2B5uGPoJmq92mdfwDxVHw%2BoJnZ2wPEZZkDHzsPJ4NbhA7H&wx_header=1
- https://blog.csdn.net/weixin_44367006/article/details/96732411

Java 实现对象排序的方式有两种：
- 自然排序： java.lang.Comparable
- 定制排序： java.util.Comparator 

Collections.sort 或者 Arrays.sort

```java
public int compare(Object obj1, Object obj2) {
            //相当于从小到大排序 大的返回正值，往后放
            return obj1.value()-obj2.value();
                        //相当于从大到小排序，大值返回负值，往前放
                        return -(obj1.value()-obj2.value());
        }
```