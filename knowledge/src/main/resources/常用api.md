### 刷题常用
```java
Comparator<Object> cmp = new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            //升序
            return o1-o2;
            //降序
            return o2-o1;
        }
    };

Collections.sort(list, new Comparator<Dog>() {

    @Override
    public int compare(Dog o1, Dog o2) {
            return o2.age - o1.age;
    }
});
        
```