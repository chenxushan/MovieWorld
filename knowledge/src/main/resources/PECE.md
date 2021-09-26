https://segmentfault.com/a/1190000008423240

简述
大家在平时的工作学习中, 肯定会见过不少如下的语句:

List<? super T>
List<? extends T>
我们都知道, 上面的代码时关于 Java 泛型的, 那么这两个不同的写法都有什么区别呢?

首先, 说到 Java 的泛型, 我们必须要提到的是Java 泛型的类型擦除机制: Java中的泛型基本上都是在编译器这个层次来实现的. 在生成的 Java 字节代码中是不包含泛型中的类型信息的. 使用泛型的时候加上的类型参数, 会被编译器在编译的时候去掉. 这个过程就称为类型擦除. 如在代码中定义的List<Object>和List<String>等类型, 在编译之后都会变成List, JVM看到的只是List, 而由泛型附加的类型信息对JVM来说是不可见的.

在使用泛型类时, 我们可以使用一个具体的类型, 例如可以定义一个 List<Integer> 的对象, 我们的泛型参数就是 Integer; 我们也可以使用通配符 ? 来表示一个未知类型, 例如 List<?> 就表示了泛型参数是某个类型, 只不过我们并不知道它的具体类型时什么.
List<?>所声明的就是所有类型都是可以的, 但需要注意的是, List<?>并不等同于List<Object>. 对于 List<Object> 来说, 它实际上确定了 List 中包含的是 Object 及其子类, 我们可以使用 Object 类型来接收它的元素. 相对地, List<?> 则表示其中所包含的元素类型是不确定, 其中可能包含的是 String, 也可能是 Integer. 如果它包含了 String 的话, 往里面添加 Integer 类型的元素就是错误的. 作为对比, 我们可以给一个 List<Object> 添加 String 元素, 也可以添加 Integer 类型的元素, 因为它们都是 Object 的子类.
正因为类型未知, 我们就不能通过 new ArrayList<?>() 的方法来创建一个新的ArrayList 对象, 因为编译器无法知道具体的类型是什么. 但是对于 List<?> 中的元素, 我们却都可以使用 Object 来接收, 因为虽然类型未知, 但肯定是Object及其子类.

我们在上面提到了, List<?> 中的元素只能使用 Object 来引用, 这样作肯定时不太方便的, 不过幸运的是, Java 的泛型机制允许我们对泛型参数的类型的上界和下界做一些限制, 例如 List<? extends Number> 定义了泛型的上界是 Number, 即 List 中包含的元素类型是 Number 及其子类. 而 List<? super Number> 定义了泛型的下界, 即 List 中包含的是 Number 及其父类.
当引入了泛型参数的上界和下界后, 我们编写代码相对来说就方便了许多, 不过也引入了新的问题, 即我们在什么时候使用上界, 什么时候使用下界, 以及它们的区别和限制到底时什么? 下面我来说说我的理解.

? extends T
? extends T 描述了通配符上界, 即具体的泛型参数需要满足条件: 泛型参数必须是 T 类型或它的子类, 例如:

List<? extends Number> numberArray = new ArrayList<Number>();  // Number 是 Number 类型的
List<? extends Number> numberArray = new ArrayList<Integer>(); // Integer 是 Number 的子类
List<? extends Number> numberArray = new ArrayList<Double>();  // Double 是 Number 的子类
上面三个操作都是合法的, 因为 ? extends Number 规定了泛型通配符的上界, 即我们实际上的泛型必须要是 Number 类型或者是它的子类, 而 Number, Integer, Double 显然都是 Number 的子类(类型相同的也可以, 即这里我们可以认为 Number 是 Number 的子类).

子类型判断
假设有类型 G, 以及 SuperClass 和 SubClass 两个类, 并且 SuperClass 是 SubClass 的父类, 那么:

G<? extends SubClass> 是 G<? extends SuperClass> 的子类型. 如 List<? extends Integer> 是 List<? extends Number> 的子类型

G<SuperClass> 是 G<? extends SuperClass> 的子类型, 例如 List<Integer> 是 List<? extends Integer> 的子类型.

G<?> 和 G<? extends Object> 等同.

可以想象 G<? extends T> 为一个左闭右开的区间(T 在最左边), G<? extends Object> 是最大的区间, 当区间 G<? extends SuperClass> 包含 区间 G<? extends SubClass>时, 那么较大的区间就是父类.

关于读取
根据上面的例子, 对于 List<? extends Number> numberArray 对象:

我们能够从 numberArray 中读取到 Number 对象, 因为 numberArray 中包含的元素是 Number 类型或 Number 的子类型.

我们不能从 numberArray 中读取到 Integer 类型, 因为 numberArray 中可能保存的是 Double 类型.

同理, 我们也不能从 numberArray 中读取到 Double 类型.

关于写入
根据上面的例子, 对于 List<? extends Number> numberArray 对象:

我们不能添加 Number 到 numberArray 中, 因为 numberArray 有可能是List<Double> 类型

我们不能添加 Integer 到 numberArray 中, 因为 numberArray 有可能是 List<Double> 类型

我们不能添加 Double 到 numberArray 中, 因为 numberArray 有可能是 List<Integer> 类型

即, 我们不能添加任何对象到 List<? extends T> 中, 因为我们不能确定一个 List<? extends T> 对象实际的类型是什么, 因此就不能确定插入的元素的类型是否和这个 List 匹配. List<? extends T> 唯一能保证的是我们从这个 list 中读取的元素一定是一个 T 类型的.

? super T
? super T 描述了通配符下界, 即具体的泛型参数需要满足条件: 泛型参数必须是 T 类型或它的父类, 例如:

// 在这里, Integer 可以认为是 Integer 的 "父类"
List<? super Integer> array = new ArrayList<Integer>();
// Number 是 Integer 的 父类
List<? super Integer> array = new ArrayList<Number>();
// Object 是 Integer 的 父类
List<? super Integer> array = new ArrayList<Object>();
关于读取
对于上面的例子中的 List<? super Integer> array 对象:

我们不能保证可以从 array 对象中读取到 Integer 类型的数据, 因为 array 可能是 List<Number> 类型的.

我们不能保证可以从 array 对象中读取到 Number 类型的数据, 因为 array 可能是 List<Object> 类型的.

唯一能够保证的是, 我们可以从 array 中获取到一个 Object 对象的实例.

关于写
对于上面的例子中的 List<? super Integer> array 对象:

我们可以添加 Integer 对象到 array 中, 也可以添加 Integer 的子类对象到 array 中.

我们不能添加 Double/Number/Object 等不是 Integer 的子类的对象到 array 中.

易混淆点
有一点需要注意的是, List<? super T> 和 List<? extends T> 中, 我们所说的 XX 是 T 的父类(a superclass of T) 或 XX 是 T 的子类(a subclass of T) 其实是针对于泛型参数而言的. 例如考虑如下例子:

List<? super Integer> l1 = ...
List<? extends Integer> l2 = ...
那么这里 ? super Integer 和 ? extends Integer 的限制是对谁的呢? 是表示我们可以插入任意的对象 X 到 l1 中, 只要 X 是 Integer 的父类? 是表示我们可以插入任意的对象 Y 到 l2 中, 只要 Y 是 Integer 的子类?
其实不是的, 我们必须要抛弃上面的概念, ? super Integer 和 ? extends Integer 限制的其实是 泛型参数, 即 List<? super Integer> l1 表示 l1 的泛型参数 T 必须要满足 T 是 Integer 的父类, 因此诸如 List<Object>, List<Number 的对象就可以赋值到 l1 中. 正因为我们知道了 l1 中的泛型参数的边界信息, 因此我们就可以向 l1 中添加 Integer 对象了, 推理过程如下:

令 T 是 l1 的泛型参数, 即:
l1 = List<T> = List<? super Integer>
因此有 T 是 Integer 或 Integer 的父类.
如果 T 是 Integer, 则 l1 = List<Integer>, 显然我们可以添加任意的 Integer 对象或 Integer 的子类对象到 l1 中.
如果 T 是 Integer 的父类, 那么同理, 对于 Integer 或 Integer 的子类的对象, 我们也可以添加到 l1 中.
按同样的分析方式, List<? extends Integer> l2 表示的是 l2 的泛型参数是 Integer 的子类型. 而如果我们要给一个 List<T> 插入一个元素的话, 我们需要保证此元素是 T 或是 T 的子类, 而这里 List<? extends Integer> l2, l2 的泛型参数是什么类型我们都不知道, 进而就不能确定 l2 的泛型参数的子类是哪些, 因此我们就不能向 l2 中添加任何的元素了.

来一个对比:

对于 List<? super Integer> l1:

正确的理解: ? super Integer 限定的是泛型参数. 令 l1 的泛型参数是 T, 则 T 是 Integer 或 Integer 的父类, 因此 Integer 或 Integer 的子类的对象就可以添加到 l1 中.

错误的理解: ? super Integer限定的是插入的元素的类型, 因此只要是 Integer 或 Integer 的父类的对象都可以插入 l1 中

对于 List<? extends Integer> l2:

正确的理解: ? extends Integer 限定的是泛型参数. 令 l2 的泛型参数是 T, 则 T 是 Integer 或 Integer 的子类, 进而我们就不能找到一个类 X, 使得 X 是泛型参数 T 的子类, 因此我们就不可以向 l2 中添加元素. 不过由于我们知道了泛型参数 T 是 Integer 或 Integer 的子类这一点, 因此我们就可以从 l2 中读取到元素(取到的元素类型是 Integer 或 Integer 的子类), 并可以存放到 Integer 中.

错误的理解: ? extends Integer 限定的是插入元素的类型, 因此只要是 Integer 或 Integer 的子类的对象都可以插入 l2 中

使用场景
PECE 原则: Producer Extends, Consumer Super

Producer extends: 如果我们需要一个 List 提供类型为 T 的数据(即希望从 List 中读取 T 类型的数据), 那么我们需要使用 ? extends T, 例如 List<? extends Integer>. 但是我们不能向这个 List 添加数据.

Consumer Super: 如果我们需要一个 List 来消费 T 类型的数据(即希望将 T 类型的数据写入 List 中), 那么我们需要使用 ? super T, 例如 List<? super Integer>. 但是这个 List 不能保证从它读取的数据的类型.

如果我们既希望读取, 也希望写入, 那么我们就必须明确地声明泛型参数的类型, 例如 List<Integer>.

例子:

public class Collections {
public static <T> void copy(List<? super T> dest, List<? extends T> src)
{
for (int i=0; i<src.size(); i++)
dest.set(i,src.get(i));
}
}
上面的例子是一个拷贝数据的代码, src 是 List<? extends T> 类型的, 因此它可以读取出 T 类型的数据(读取的数据类型是 T 或是 T 的子类, 但是我们不能确切的知道它是什么类型, 唯一能确定的是读取的类型 is instance of T), , dest 是 List<? super T> 类型的, 因此它可以写入 T 类型或其子类的数据.

参考
Java深度历险（五）——Java泛型
difference-between-super-t-and-extends-t-in-java