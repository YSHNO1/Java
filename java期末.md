### Java期末考试

题型：单选 多选（告诉了有几个选项） 填空 判断 主观题  编程题

**前面的概念也会考maven一类的**

**重点是PPT的内容**

#### 1 会写符合高质量要求的代码

**高质量代码的注解：**

用简短的几句话总结代码想要做的事情，或者在一个高度的层面上对代码进行描述。还可以用于来表达一些代码本身不能表达的事情，比如版本号啊，版权声明啊等等

**命名的要求**

Package: org.edu.zju.cst

**类和接口**：驼峰命名，使用完整的单词，内部的每一个单词的首字母大写 UserCount

**方法：**使用动词，第一个字母小写，其余单词的首字母大写 setName

**变量：**第一个字母小写，其余单词的首字母大写，避免使用_和$ myName

**常量**：全部大写，单词之间使用_隔开 MAX_NUMBER 

**声明**：一行只声明一个变量；数组的声明最好写为 int[] args；即使if只包含一条语句也要使用大括号；循环要注意避免设置太多的变量，switch要注意每一个case都要break,若不包含最好说明情况，每个switch都要包含default;

**异常捕获若不处理**，最好给出解释；

如果代码一行写不下，那么需要在合适的的地方进行断开，下一行的代码要与上一行保持整齐

#### 2 **泛型** **generic** 

掌握最基本的概念 编程题目开发工具类(高质量要求)

Java1.5开始引入的java泛型类，避免了之前在创建集合对象时，由于继承自Object类，可以放入任何的类型的数据，但是在编译时无法检查到错误，运行时才会检查到。List<String> names = new ArrayList<String>();这样限制了类型。就能在编译时检测到违法的操作。

参量多态Parametric polymorphism 其实也就是泛型的前身

能达到在未知类型的情况下，方法或者类型能够以相同的方式来对值进行处理。这样子就保证了类型安全。

在Java的Collection中用的最多，同样也在反射 reflection中用到了

**怎么实现一个泛型类 基础语法**

ArrayList泛型的定义  实际的类型都使用了E来替代，在实际的调用中，将其按需赋值为实际的类型。 要注意所有需要在调用时指定的的类型都需要设置为E

**public class ArrayList<E> extends AbstractList<E> implements List<E>{**

​     **public boolean add(E o){**

​    **}**

**}**

**注意在需要判断E类型是否安全时，一定要使用equals();**

**注意：**

如果在类中使用单个泛型方法时（通常为静态），需要在其返回类型之前加上类型参数，注意下面的copy函数声明前的参数

Public class Collections{

  public static <T> void copy(List<T> dst, List<T> src){

​    ……

} 

} 

一般是不需要自己来创建一个泛型类的  dbq。。。。

**受限的类型参数**

**这是一个上限upper bound，接受给定的超类型或其任何的子类型**

**<Type extends SuperType>** extends可以理解为is a

<T extends Comparable<T>>

**<Type extends ClassA & InterfaceB $ InterfaceC & ……>**

**这是一个下限lower bound 接受任何给定的超类型或超类型的任何超类型**

**<Type super SuperType>**

找最值的时候可能会用到Comparable，那么在定义泛型方法的时候需要指明一下，如下需要找出集合中的最大值，则需要这么定义

Public static <T extends Comparable<T>> T max(Collection<T> c){}

如下需要实现一个复制：

Public static <T> void copy(List <? super T > dst, List<? Extends T> src)

要将所有的元素从src复制到dst,这样子的，dst需要安全的存储来自src的所有元素。这也就意味这src所有的元素必须都是dst元素的类型或者其子类型

 

**数组和泛型的区别**

数组是具体化的，泛型是擦除的

数组的类型检查会在运行时再次执行，但是集合类型只会在编译时执行

所有的泛型类在编译后都会变成Object，在运行时，所有的泛型实例都是同样的类型 

List<String> lst1 = new ArrayList<String>();

List<Integer> lst2 = new ArrayList<Integer>();

lst1.getClass() == lst2.getClass() //他的返回值为true

**注意不能使用instanceof**                                                       
 **泛型不能创建参数化的类型或者数组，但可以创建该类型的变量，将其作为参数**

![image-20201113093255201](C:\Users\YSH\AppData\Roaming\Typora\typora-user-images\image-20201113093255201.png)

![image-20201113093303632](C:\Users\YSH\AppData\Roaming\Typora\typora-user-images\image-20201113093303632.png)

泛型数组是不安全的，数组是协变（covariant）的，泛型是可变(invariant)的。

简单而言就是如果sub是super的子类型，那么sub[]就是super[]的子类型

但是对于任意两个不同的类型Typel和Type2, List<Type1＞既不是List< Type2＞ 的子类型，也不是List<Type2＞的超类型

 

**通配符 ？** 

在方法参数中使用通配符时，编译器会组织你进行一些可能会破坏参数列表的操作。以下二者的声明时等价的

Public <T extends Animal> void takeThing(ArrayList<T> list)

Public void takeThing(ArrayList<? Extends Animal> list)

泛型和数组 和子类的关系 编译能否通过等

**把不是泛型的改成泛型 一些注意点
** 书上第29条的例子，泛型数组是一定不能被创建的，但是可以创建Object类型的数组，然后将他强制转换为E类型，此处就可以使用消除受检异常的标记

   @SuppressWarnings(“unchecked”),又如下面的例子：

![image-20201113093318008](C:\Users\YSH\AppData\Roaming\Typora\typora-user-images\image-20201113093318008.png)

   注意各种对应的参数种类与区别

![image-20201113093330797](C:\Users\YSH\AppData\Roaming\Typora\typora-user-images\image-20201113093330797.png)

强制转换标注忽略警告 @SuppressWarnings(“unchecked”)

要注意SuppressWarnings要标注到具体的内容，不要整个类或者整个方法,注意英文拼写正确

#### 3 通用编程

**基元类型**比较相等性 double float

基本类型要优先于装箱基本类型

基元类型和装箱类型的区别 

int Integer 

double Double 

boolean Boolean

 二者之间主要有三个区别：

1 基本类型只有值，而装箱基本类型则具有与他们的值不同的同一性，换句话说，两个装箱类可可以具有相同的值和不同的同一性。

2 基本类型只有函数值，而每个装箱基本类型则都有一个非函数值，null

3 基本类型通常要比装箱基本类型更节省时间和空间。

注意PPT的例子，传入参数为装箱类比较大小时，可能不会得到预期的结果，对装箱基本类型使用==操作符几乎时错误的

当在一项操作中混合使用基本类型和装箱基本类型时，装箱基本类型就会自动拆箱。但是当你Integer a;此时a是null,对他进行拆箱会抛出NullPointerException错误

哪些是在编译进行的 哪些是在运行进行的

装箱是在编译时进行的

**什么时候使用装箱基本类型呢？**

1 作为集合中的元素、键和值，（不能将基本类型放在集合中，因此必须使用装箱基本类型）

2 在参数化类型和方法中，必须使用装箱基本类型作为类型参数。

3 在进行反射方法的调用时，必须使用装箱基本类型

此外要尽可能使用的基本类型。，更加简单也更加的快速。

 要了解并使用类库

random方法是假的随机数，Random.nextInt（int）很好的解决了这个问题

常见的java.io java.lang java.util都i要熟悉

避免使用float和double,如果你需要精确的数值，因为他们不能精确的表示小数，使用BigDecimal、int、或者long进行运算，BigDecimal运算比较慢

**优化的概念和理念**

优化弊大于利，要写出好的程序而不是快的程序，努力避免那些限制性能的决策，避免不成熟的优化

在遍历集合和数组时优先使用**for each** 有很多好处。。。能够简化编程，并且能够避免很多不必要的错误。

但是有三种情况是不能使用for each

1 解构过滤，需要遍历集合然后删除选定的元素，就需要使用显式的迭代器

2 转换 需要遍历数组然后修改某些值时，则必须使用迭代器

3 平行迭代 并行的遍历多个集合 保证所有迭代器的变量同步前进

慎用变长参数（Java1.5之后被提出来的）

注意传入的参数的形式，可能是空数组，所以要进行检测，或者直接限制传入的参数形式，一个定长，一个变长

将局部变量的作用范围最小化，最好是在使用之前再进行声明 for循环为例

如果可以替代，那么最好避免使用字符串

字符串不适合代替其他的值类型，不适合代替枚举类型。不适合代替聚合类型，也不是和代替能力表

不要使用字符串连接操作符来合并多个字符串，会严重影响性能，应该使用StringBuilder的append方法

记得String是不可变的类，StringBuilder是它对应的可变的类

#### 4 方法

**检查参数的有效性**

当一个方法有一些参数是违规的，那么需要对他进行提前检查，当然不能耗费很大的代价，同时要在文档中进行注释  要使用Javadoc的@throw对可能抛出的异常进行标注

当然对于此类异常通常为@throw IllegalArgumentException

当然对于一些内部的私有方法，因为调用他们是默认是满足了前提条件的，可以不进行检查

**defensive copy的用法**（保护性拷贝）

Java是一门安全的语言，它对于缓冲区溢出、数组越界、非法指针及其他的 内存破坏错这些严重影响着C/C++的问题都会自动免疫。但是仍然要将你的类与客户端隔离开来

因为假设类的客户端会尽其所能来破坏这个类的约束条件，因此必须保护性的设计程序

如下面的程序：

![QQ图片20201114122506](C:\Users\YSH\Pictures\md的图片\QQ图片20201114122506.png)

单纯的从类来看，这个类是不可变的，并且加强了约束条件start不能在end后面的，所但是Date类本身是可变的，因此在外部定义时是可以随意的对变量进行修改（现在都是用Instant，这个类是不可变的。Date已经过时了）

为了保护上面类内部的信息免遭这种攻击，所以需要对构造器的每个参数进行保护性的拷贝。并且使用备份的对象作为实例的组件，修改如下：

![QQ图片20201114123000](C:\Users\YSH\Pictures\md的图片\QQ图片20201114123000.png)

总而言之，需要对客户端提供的所有可变的参数进行防御性的拷贝

**要尽可能的使用不变的对象**

重写克隆方法得注意点 **clonable 接口实现方式**

**慎用重载override**

overload 重载  具体调用会调用哪个方法  静态的由编译器决定选择哪个方法执行

具体调用哪个重载方法是在编译时做出决定的。

 但是对于重载方法的选择是静态的，而对于被覆盖的方法的选择是动态的。

![QQ图片20201114154014](C:\Users\YSH\Pictures\md的图片\QQ图片20201114154014.png)

在上述的代码中，classifty被重载，但是在调用时因为都是Collection<?>,所以会打印三次Unknow Collection

为了不混淆：不要导出两个具有相同参数的重载

最好不要使用重载，使用静态工厂方法

**override 重写**（子类重写父类的方法） 动态的 更加面向对象，动态的由系统运行时决定

![img](file:///C:\Users\YSH\Documents\Tencent Files\1028509048\Image\C2C\}V$U9R4B$]KXF{O0GK}K8F5.png)

**当为空时，返回零长度的数组或者集合，而不是null**

**会写注释，按照高质量要求**

为所有导出API的元素编写文档注释

在每个导出的类、接口、构造函数、方法和字段描述之前添加文档注释，不应该有两个成员构造函数具有相同的摘要描述

每一个方法都应该具有

@param  每个参数的标签

@return  返回标签除非是void类型

@throws   异常标签

一个好的例子：

第一句话是整段注释的一个摘要：精简的描述方法想要实现的功能等

![img](file:///C:\Users\YSH\Documents\Tencent Files\1028509048\Image\C2C\Q}NYZIZ]U}G7L4ZVODCYO9L.png)

要注意。因为注释中包含HTML元素，所以一些符号的出现可能要采用特殊的动作

使用{@literal}标签将他们包围起来，这样就不会识别为HTML标记语言

一些常见的：方法/构造器：通常使用动词短语来描述这个方法所执行的内容

类/接口/域：一般是用一组名词短语描述他所代表的事情

#### 5 同步

最基本的一些概念 

**volatile关键字**

volatile修饰符不执行互斥访问，它可以保证任何一个线程在读取该区域时都将看到最近刚刚被写入的值，但是它不能保证互斥性

![QQ图片20201114204047](C:\Users\YSH\Pictures\md的图片\QQ图片20201114204047.png)

如上面这个例子，他想要确保每个调用都返回不同的值，但是增量操作符不是原子的，如果第二个线程在第一个线程读取旧值和返回新值的期间读取这个域，第二个线程就会与第一个此案成看到同样的值，返回相同的序列号，这就是安全性失败

修改可以采用synchronized关键字，但是最好使用java.util.concurrent.atmoic的AtomicLong类

![QQ图片20201114204641](C:\Users\YSH\Pictures\md的图片\QQ图片20201114204641.png)

**synchronized关键字** 

synchronized关键字可以保证在同一时刻，只有一个线程可以执行某一个方法，或者某一个代码块，在类型声明前加上关键字即可

当然要注意需要将读写都加上同步，否则无法起作用

**用法 还有二者的区别 拼写对**

注意synchronized关键字实现的是互斥访问，但是volatile关键字并没有

当然避免过度的同步，当可变的数据由多个线程调用时，则必须进行同步互斥操作

**多线程里面不要调用什么**

为了避免死锁和数据破坏，千万不要从同步却与内部调用外来方法，更通俗的讲，要尽量将同步区域内部的工作量限制到最少

**注意线程的安全性和级别**

**每个类在线程安全方面是什么级别**

一个类为了可以被多个线程安全的使用，必须在文档中清楚的说明它所支持的线程安全性级别：

1 不可变的 immutable 这个类的实例时不可变的，所以不需要外部的同步String Long BigInteger

2 无条件的线程安全（unconditionally thread-safe）实例是可变的，但是这个类有着足够的内部同步，所以它的实例可以并发使用，无需任何外部的同步 AtomicLong  ConcurrentHashMap

3 有条件的线程安全（conditionally thread-safe）除了有些方法为了安全需要进行外部同步之外，这种线程的安全级别与无条件的线程安全相同 Collection.synchronized包装返回的集合，它的迭代器要求外部同步

4 非线程安全（not thread-safe ）这个类的实例是可变的，为了并发的使用它们，刻划断必须利用自己选择的外部同步包围每个方法调用，这个例子包括通用的集合实现，如Arraylist和HashMap

5 线程对立的（thread-hostile） 这种类不能安全的被多个线程并发使用，是因为在写的时候就没考虑到并发性

要注意在文档中描述一个有条件的线程安全类要很小心，必须指明哪个调用序列需要外部的同步，需要指明为了执行这些序列，必须获得哪一把锁

**私有锁**Private Lock  把对象封装在他所同步的对象中，因为私有锁对象不能在这个类之外访问，也不能被这个类的客户端程序所访问

总是要定义为final  只能用于无条件线程安全的类

private final Object lock = new Object();

**慎用延迟初始化**

在大多数的情况下，正常的初始化要优先于延迟初始化。如果要使用延迟优化来破坏初始化的循环，就要使用同步访问方法

如果处于性能的考虑而需要对静态域使用延迟初始化，就使用lazy initlization holderclass模式

如果处于性能的考虑而需要对实例域使用延迟初始化，就是用双重检查模式（double-check idiom）.

**实现单例模式 双检是怎么实现的**

两次检查域的值，第一次检查时没有锁定，看看这个域是否被初始化了；第二次检查时有锁定，因为只有第二次检查时表明这个域没有被初始化，才会对这个域进行初始化，以下为实现：注意使用了volatile

![QQ图片20201114214053](C:\Users\YSH\Pictures\md的图片\QQ图片20201114214053.png)

双检查的实现：

`private volatile FieldType field;`

`private FieldType getField() {`

​	`FieldType result = field;`

​	`if(result == null) {`

​		`synchronized(this) {`

​			`if(field == null) {`

​				`field = result = computeFieldValue();`

​			`}`

​		`}`

​	`}`

`}`

#### 6 Object  对于所有对象都通用的一些方法

**哪些方法是object的 ，**

尽管Object是一个具体的类，但是设计他主要是为了扩展。他的final方法（equals、  hashCode、 toString、 clone、 和 finalize）都有明确的通用协定，在进行override时需要注意遵循一些规则

**怎么样来正确的重写equals方法** 不能用第三方 自己实现（最好避免重写）

要遵循通用协定，在满足以下条件时就不需要重写：

1 类的每个实例本质上都是唯一的（枚举）代表活动实体而不是值（value）

2 类没必要提供逻辑相等的测试功能（random class）

3 父类已经重写了equals，并且父类的equals也适合用于这个类。 Set 继承于AbstractSet

4 类是私有的或者是包级私有的，可以确保他equals方法永远都不会被调用

**equals方法的一些通用协定** equals方法前加注解 @Override

1. 自反性reflexivity  x.equals(x)的返回值一定是true  
2. 对称性symmerty x.equals(y)那么一定有y.equals(x) 
3. 传递性transitivity xyz三者可以两两比较的返回值都为true
4. 一致性consistency 对于非null的x和y,只要equals 的比较操作在对象中所用的信息没有被修改那么x.equals(y)返回值始终为true，
5. 对于任何非null的x x.equals(null) 的返回值一定是false

但是实现这些是有困难的：

自反性是自动的

对称性并不是，如以下的例子：

![QQ图片20201113104453](C:\Users\YSH\Pictures\md的图片\QQ图片20201113104453.png)



在上面的类中，想要将类内部的字符串与外部普通的字符串对象进行比较。不区分大小写。那么在调用时就会出现以下的情况：

![QQ图片20201113104629](C:\Users\YSH\Pictures\md的图片\QQ图片20201113104629.png)

前一个equals调用的是覆盖后的方法，返回值为true，但是后一个equals调用的是String的equals方法，返回的是false

修改方法是对其进行重构

![QQ图片20201113104953](C:\Users\YSH\Pictures\md的图片\QQ图片20201113104953.png)

传递性也很容易违背。eg 子类增加的信息会影响equals的比较结果

在书中的点类，当子类对父类进行扩展增加了颜色的信息后，重写equals方法就会导致比较的结果不一致，父类的方法会忽略颜色，但是子类会考虑  这样就破坏了对称性

改良一在混合比较时忽略颜色的信息，这样虽然保证了对成性，但是无法保证传递性

我们无法在扩展可实例化的类的同时，既增加新的值组件，又能同时保留equals的约定

**里氏替换原则：（Liskov substitution principle）**:一个类型的任何重要属性也将适用于他的子类型，因此为该类型编写的任何方法，在它的子类型上也应该用样的运行的很好

虽然没有一种令人满意的方法可以既能扩展不可实例化的类。又增加值的组件，但是根据复合优先继承的建议可以对类进行一些修改

**如何实现高质量的equals()方法**：

1 使用==操作符检查“参数是否为这个对象的引用” 是则返回true

2 使用instanceof操作符检查“参数是否为正确的类型”是则返回true

3 把参数转换为正确的类型

4 对于该类中的每个关键（significant）的域，检查参数中的域是否与该对象中对应的域相匹配

5 检查自反性、对称性、传递性

对于既不是float 也不是double 类型的基本类型域，可以使用＝＝操作符进行比较；
对于对象引用域，可以递归地调用equals 方法；对于float 域，可以使用静态、Float.
compare(float, float ）方法；对于double 域，则使用Double . compare( double, double ）。

（书上39页有个phoneNumber的例子）

![](C:\Users\YSH\Pictures\md的图片\QQ图片20201108103127.png)

**一些告诫**

覆盖equals方法时总要覆盖hashCode

不要企图让equals方法过于智能

不要让equals声明中的Object对象替换为其他的类型

不要抛出空指针异常（NullPointerException）或者找不到类(ClassCastException)的异常


**覆盖equals方法时总要覆盖hashCode**

hashCode 怎么重写 对于每种不同类型是怎么比较和取值的

**一些hashcode的通用协定**

1 ，只要对象的equals 方法的比较操作所用到的信息没有被修改，那么对同一个对象的多次调用， hashCode 方法都必须始终返回同一个值。在一个应用程序与另一个程序的执行过程中，执行hashCode 方法所返回的值可以不一致。

2 如果两个对象根据equals(Object ）方法比较是相等的，那么调用这两个对象中的hashCode 方法都必须产生同样的整数结果。

3 如果两个对象根据equals(Object ）方法比较是不相等的，那么调用这两个对象中的hashCode 方法，则不一定要求hashCode 方法必须产生不同的结果。但是程序员应该知道，给不相等的对象产生截然不同的整数结果，有可能提高散列表（ hashtable ）的性能。

注意phoneNumber那个例子  实际的返回值是null，因为该类覆盖了equals方法，但是没有重写hashCode方法，所以导致两个相等的实例具有不同的散列码。因为HashMap有一项优化是，将每一项与关联的散列码缓存起来，如果散列码不匹配，就不会再去检验对象的等同性。

**hashcode的重新计算的方法**

直接返回一个固定的值，这样子是合法的，但是千万不要这么做

@Override public int hashCode() {return 42;}，这使得每个对象都具有相同的散列码

解决办法：

1. 声明一个int 变量并命名为result ，将它初始化为对象中第一个关键域的散列码c 
2. 对象中剩下的每一个关键域f 都完成以下步骤：
a . 为该域计算int 类型的散列码C:
I . 如果该域是基本类型，则计算Type. hashCode ( f ），这里的Type 是装箱基本类型的类，与f 的类型相对应。
II .如果该域是一个对象引用，并且该类的equals 方法通过递归地调用equals的方式来比较这个域，则同样为这个域递归地调用hashCode 。如果需要更复杂的比较则为这个域计算一个“范式”（ canonical representation ），然后针对这个范式调用hashCode 。如果这个域的值为null，则返回0 （或者其他某个常数，但通常是0）
皿． 如果该域是一个数组，则要把每一个元素当作单独的域来处理。也就是说，递
归地应用上述规则，对每个重要的元素计算一个散列码，然后根据步骤2. b中的做法把这些散列值组合起来。如果数组域中没有重要的元素，可以使用一个常量，但最好不要用0 。如果数组域中的所有元素都很重要，可以使用Arrays . hashCode方法。
b . 按照下面的公式，把步骤2 . a 中计算得到的散列码c 合并到result 中：
result = result  + c；
3. return result;

`private int hashCode = 0;`

 `@Override public int hashCode(){`

 `if (hashCode == 0)`

 `{.....//进行hashCode的计算}`

 `else return hashCode`

 `}; `

**总要覆盖toString方法**

​	Objectt的toString默认的返回值是类的名称@散列码的无符号的十六进制表示，这不方便阅读，所以建议都要覆盖toString方法

在实际应用中，toString方法应该返回对象中包含的所有值得关注的信息 。如果对象太大，或者对象中包含的状态信息难以用字符串表达，那么toString应该返回一个摘要信息

是否在文档中指定返回值的格式呢？

对于电话号码、矩阵类建议这么做。它可以被用作一种标准的、明确的、适合人阅读的对象表示法。这种表示法可以用于输入和输出，以及用在永久适合人类阅读的数据对象中

**指定后也有一些不足之处**

如果这个类已经被广泛使用，一旦指定格式，就必须始终如一地坚持这种格式。程序员将会编写出相应的代码来解析这种字符串表示法、产生字符串表示法，以及把字符串表示法嵌入持久的数据中。如果将来的发行版本中改变了这种表示法，就会破坏他们的代码和数据

当然无论指定与否，都需要在文档中明确的表明你的意图，都需要为toString返回值中包含的所有信息提供一种可以通过编程访问的途径

**clone方法怎么正确实现**  谨慎的覆盖clone()方法

Cloneable是一个‘mixin’接口，表明这样的对象允许克隆

有一些约束，但是非常的弱

对于任何对象X ，表达式x.clone() != x将会返回结果true ，

并且表达式x.clone().getClass() == x.getClass()将会返回结果true ，但这些都不是绝对的要求。通常情况下，表达式x.clone() .equals(x)将会返回结果true ，但是，这也不是一个绝对的要求。

如果一个类实现了Cloneable, Object 的clone方法就返回该对象的逐域拷贝，否则就会抛出CloneNotSupportedException 异常（要注意数组被认为实现了克隆的接口）

正常的情况，克隆完成后，此对象的类的新实例被创建成功并且它的所有字段都用这个对象对应字段的内容初始化，就像通过赋值一样，字段的内容本身并没有被克隆

要注意浅拷贝而不是深拷贝

如果类的每个字段包含基本类型或多不可变对象的引用，那么重写clone方法很容易

只需使用public方法来覆盖clone,该方法的返回类型是类本身

![QQ图片20201113121215](C:\Users\YSH\Pictures\md的图片\QQ图片20201113121215.png)

不可变的类永远都不应该提供克隆方法

如果一个类只有原始域或者不可变引用作为域，那么super.clone()就能返回你想要的内容

对于具有可变引用的对象，需要深度拷贝

存在的一些问题：

1 对于final字段，clone可能会存在一些问题

2 递归的克隆可能不够

总而言之最好不用使用clone.不要实现Cloneabl接口，最好提供单独的复制机制

Stack的克隆

![QQ图片20201113122130](C:\Users\YSH\Pictures\md的图片\QQ图片20201113122130.png)

**Comparable方法** 的契约 抛出异常 equals抛不出

一些约束： 根据此对象和对象的顺序返回负、0或这正

需要满足sgn(x.compareTo(y) == -sgn(y.compareTo(x))并且还要保证这个关系是可以传递的

如果x.compareTo(y) == 0, x 和 y 与z相比的结果必须是一致的

建议x.compareTo(y) == 0 当x.equals(y)时

要注意CompaerTo是可以抛出ClassCastException的

千万不要被上述约定中的数学关系所迷惑。如同equals 约定一样，compare To 约定并没有看起来那么复杂。与equals 方法不同的是，它对所有的对象强行施加了一种通用的等同关系， compareTo 不能跨越不同类型的对象进行比较：**在比较不同类型的对象时， compareTo 可以抛出ClassCastException 异常**。通常，这正是compareTo 在这种情况下应该做的事情。合约确实允许进行跨类型之间的比较，这一般是在被比较对象实现的接口中进行定义。

```
Object x = new BigDecimal(“1.0”);
Object y = new BigDecimal(“1.00”);
```

在这里x.equals(y)的值为false  但是x.compareTO(y)==0

eg2

```
Set s = new HashSet(); 
Set t = new TreeSet();
s.add(x); s.add(y);  // HashSet uses equals, so s has 2 elements
t.add(x); t.add(y);  // TreeSet uses compareTo, so t has 1 element
```

和泛型结合怎么定义

Comparable接口的定义

`public interface Comparable<T>{`

​	`public int compareTo(T o);`

`}`

使用该接口

`public static <T extends Comparable<? super T>> void sort(List<T> list){}`

**和访问控制权限有关的  子类放大权限什么时候允许 什么时候不允许**

**不同的java语言版本之间的区别 (常识)**

**泛型 枚举啥时候引入的 哪个版本 知道一些版本变迁历史**

**不要定义成员变为public**

**把继承关系改成组合 分析哪些方面可以封装**

**接口抽象类区别 了解**

**嵌套类基本概念 内部类**

#### 7 静态工厂方法

通过一个静态方法来对外提供自身实例的方法，就是我们所说的静态工厂方法（Static factory method）, 例如：

`Integer number = Integer.valueOf("3")`

传统的**new**来创造一个实例时，告诉jvm来再内存中开辟出一篇新的空间，然后调用构造函数来初始化成员变量，最终把引用返回给调用方

**实例受控制的类：**可以控制在哪些时刻有哪些实例存在

**使用静态工厂方法有几个好处**

1 静态工厂方法有名字，这样子就更能清晰的表达函数的意义。因为java的构造函数和类名是一样的，这样就会导致需要多个构造器时发生问题静态工厂方法可以给方法起更多的有意义的名字来准确的识别需求

2 不必每次调用他们都创建一个新对象  可以使用实例受控的类，这样就能避免创建不必要的重复对象。实例受控的类可以确保他是一个Singleton或者是不可实例化的。当且仅当a==b时，才有a.equals(b)为true

3 可以返回原返回类型的任何子类型的对象  如java.util.Collection类.构造方法只能返回确切的自身类型，而静态工厂方法则能够更加灵活，可以根据需要方便地返回任何它的子类型的实例

4 在创建带泛型的实例时，可以更加的简洁

**静态工厂方法也有几个缺点：**

1 类如果不含共有的或者受保护的构造器，就不能被子类化。这也就鼓励程序员使用复合（composition）,而不是继承。

2 没有特别的文档注释支持

3 因为没有特定的命名，所以程序员很难发现他们

下面是一些惯用的名称：

valueOf（），类型转换器

getInstance()， 返回参数描述的实例

newInstance()，同getInstance，但是保证了不同的对象

getType（），同getInstance()，但是转换了对象

newType（），同newInstance()，但是转换了对象

**构建器 builder**

静态工厂和构造器都不能很好的解决可选参数非常大量的时候

JavaBean模式弥补了重叠构造器模式的不足，但是因为构造过程被分到了几个调用中，所以JavaBean在构造过程中可能处于不一致的状态

建造者模式Builder

![QQ图片20201113100430](C:\Users\YSH\Pictures\md的图片\QQ图片20201113100430.png)

builder的一些缺点：

在注重性能的情况下，创建builder会有额外的开销

**Singleton**：表示仅仅被实例化一次的类（一个类只有一个实例，并且提供一个访问他的全局访问点。。。。。windows的多线程，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个文件的现象，所以所有文件的处理必须通过唯一的实例来进行）

**通过私有构造器强化不可实例化的能力**

一些工具类，比如jav.lang.Math java.util.Arrays等实例化没有任何的意义

企图通过将类设定为抽象类来强制该类不可被实例化时行不通的

（因为这种类是可以被子类化的，该子类可以被实例化，可能会导致用户误以为这种类是为了继承而设置的）**只要让这个类包含一个私有的构造器，他就不能被实例化**因为只有当类不包含显示的构造器时，编译器才会生成缺省的构造器

**避免创建不必要的对象**

性能是仅次于正确性的要求，创建不必要的对象是垃圾代码

String s = new String(“hello”) 这样子做就太蠢了

String s = "hello" 应该这么做 

最好能重用单个对象

对于不可变类，优先使用静态工厂方法而非构造方法

但是这并不意味着创建对象时昂贵的，在现在的jvm上小对象的创建是廉价的，程序的可读性要更加的重要

有时候java的垃圾回收机制没起作用会造成内存的泄露

在支持垃圾回收的语言中，内存泄漏是很隐蔽的，如果一个对象引用被无意思的保存起来，那么垃圾处理机制就不会处理这个对象，并且也不会被这个对象引用的所有其他的对象

在栈的一个例子中，出栈的位置应该被置空，但是清空对象应该是一种例外，而不是一种规范的行为，在大多数情况下都不需要这么做

消除过期引用的最好方法是让包含该引用的变量结束生命周期

如果类自己来管理内存，那么程序员就需要警惕内存泄露的问题

**发生类似内存泄露的情况  ，哪些情况需要手动设置变量为null（栈stack溢出的那个例子）**

要避免使用终结方法

#### **8 枚举和注解**

**了解枚举类** 内部也可以定义方法 

枚举模式(enum pattern)是指由一组固定的常量组成合法值的类型 比如一年的四季，花色等，一般是用int常量来代替枚举类型。

但是不能很好的区分不同的类型，因为看值都是int，可以相互操作

并且其程序是非常脆弱的，因为int是编译时常量，他们的int值会被编译到客户端中，如果要修改生效，则必须重新编译，否则客户端会一直保留初始的值

并且很难转换为可打印的字符串，因为你见到的只是一个数字并不知道实际含义

也很难进行迭代便利

String模式的枚举，虽然字符串有了实际的含义，但是将这些常量编译到了客户端，后续的操作很依赖字符串的比较，这面临着书写错误等多种风险

**枚举类型 enum type**

Public enum APPLE{}

这样子就可以为每个枚举常量导出一个实例，并且没有提供构造器，是真正的final类，客户端不能创建枚举类型的实例，也不能对他进行扩展，其本质是单例Singleton的泛型化，是单元素的枚举

能够保证编译时的类型安全，每一个常量都有自己的命名空间，所以包含同名常量的多个枚举类型可以在一个系统中和平共处。当然也可以修改增加枚举类型中的常量，并且不需要重新编译客户端代码

**系统自带的一些方法和属性  ppt里边有**

枚举默认有一个静态的values()方法，按照声明顺序返回它的值数组。toString()方法返回每个枚举值的声明名称，当然你可以通过覆盖对他进行修改

如书中128页的枚举的例子，原始的地方法没有throw就不能执行，但是实际上并不能执行到throw,如果添加了新的运算符，但是没有增加case条件，编译仍然可以正常的进行。但是在运行时会发生问题

第二种方法，定义了一个抽象的方法apply，因为每个枚举类型中地抽次昂发给发都必须被他的所有常量中地具体方法覆盖，那么如果进行增加，编译器会提醒你增加新地覆盖方法，当然也可以重写toString方法，返回具体地操作符更加地便于阅读

实现了comparable接口 int compareTo(E) 所有的枚举类型会按照声明地顺序进行比较

可以用＝＝比较， 不用非要使用equals方法

String name() 其实和toString方法是类似地，对于Operation.PLUS返回PLUS

int ordinal() 按照声明顺序返回 0 1 .。。要避免使用这种方法，而是直接将对应地数值保存在一个实例域中。

 //String方法有一个自动产生地valueOf(String)方法，它将常量地名字转换为常量本身。要想覆盖toString方法，要考虑实现一个fromString方法，将定制地字符串表示法变回对应地枚举（非重点）

**注解的作用**

使用注解的情况

来标识代码的错误，消除编译器的警告，单元测试等

向编译器提供一些信息地标记，还可以用于部署或者运行时处理

一般是用来检测代码地问题或者错误，禁止编译器发出警告，为了单元测试等

@AnnotationName(param=value, param=value…)

@SuppressWarnings(“unchecked”)

@Test(timeout=2000)

常见的注解 拼写正确 @override之类的

@SuppressWarnings 阻止编译器发出警告

@Override 来自父类的方法将会被覆盖  这个很常用，并且在覆盖父类的方法时一定要使用，有以下几个好处：

可以避免重载和重写的错误

可以提示编译器，编译器可以帮你检查代码错误

对于抽象类和接口都很重要

@Deprecated 不建议使用的代码

@Retention 使得注释的数据在运行时可用

在Java1.5之前是使用命名模式的 比如Junit会根据test来识别一个方法是否为测试方法，注解的出现解决了很多问题。可以自动地拼写错误进行诊断，还能传参

#### 9 异常

**常见的异常类** 什么情况下会抛出 

![QQ图片20201113221859](C:\Users\YSH\Pictures\md的图片\QQ图片20201113221859.png)

| Exception                      | 描述                         |
| ------------------------------ | ---------------------------- |
| Exception                      | 异常层次结构的根类           |
| RuntimeException               | 运行时异常的基类             |
| ArithmeticException            | 算术错误，比如除数为0        |
| IlleagalArgumentException      | 接收到非法参数               |
| ArrayIndexOutOfBoundsException | 用非法索引访问数组时抛出     |
| NullPointerException           | 空指针异常，尝试访问null对象 |
| ClassNotFoundException         | 不能加载所需的类             |
| NumberFormatException          | 数字转转化格式异常           |
| IOException                    | I/O异常的根类                |
| FileNotFoundException          | 找不到文件                   |
| EOFException                   | 文件结束                     |
| InterrupedException            | 线程中断                     |
| ClassCastException             | 类强制转换异常               |

常见的举例

//ArithmeticException

`int x = 0；`

`System.out.println(1 / x);`

// NullPointerException

`Object o = null;`

`System.out.println(o.toString);`

//NumberFormatException

`int err = Integer.parseInt("hi")`

//FileNotFoundException

`Scanner in = new Scanner(new File("notHere.txt"));`

//ArrayIndexOutOfBoundsException  数组下标越界

`int a = [1, 2, 3, 4];`

`System.out.println(a[4]);`

//ClassCastException

`Object text = new String("aaa");` 

`Integer num = (Integer) text;`

常见的受检异常 

![img](file:///C:\Users\YSH\Documents\Tencent Files\1028509048\Image\C2C\GUVRO85GO`@W{C__MZ@$`VN.png)

常见的非受检异常

Java.lang.ArithmeticException

Java.lang.ArrayStoreExcetpion

Java.lang.ClassCastException

Java.lang.EnumConstantNotPresentException

Java.lang.IllegalArgumentException

Java.lang.IllegalThreadStateException

Java.lang.NumberFormatException

Java.lang.IllegalMonitorStateException

Java.lang.IllegalStateException

Java.lang.IndexOutOfBoundsException

Java.lang.ArrayIndexOutOfBoundsException

Java.lang.StringIndexOutOfBoundsException

Java.lang.NegativeArraySizeException’

Java.lang.NullPointerException

Java.lang.SecurityException

Java.lang.TypeNotPresentException

Java.lang.UnsupprotedOperationException

声明受检异常，抛出异常，捕获异常（在方法声明处就需要指定抛出的异常）

调用抛出异常的方法时，也需要catch或throw异常，除非是运行时异常

捕获异常，自java7开始，就可以在一个catch捕获多个异常了

try{

}catch(FileNotFoundException | UnknowHostException e){}

当然内部的两个异常不能是父子关系，如果要捕获多个异常，那么子类的异常要在父类之前

finally通常用于做个收尾工，关闭文件之类的。当然最好不要在他的内部执行返回操作

注意以下可能发生的情况：

![QQ图片20201113165933](C:\Users\YSH\Pictures\md的图片\QQ图片20201113165933.png)

继承自RuntimeException

![QQ图片20201113150335](C:\Users\YSH\Pictures\md的图片\QQ图片20201113150335.png)

知道是受检异常还是非受检异常

非受检异常表明编程错误

受检异常表明恢复到正常的条件，需要开发者处理异常

更高层的实现应该捕获底层的异常，同时抛出可以按照高层抽象进行解释的异常（异常转译）

始终要单独的声明受检异常，利用javadoc的@throw标签，准确的记录下抛出每个异常的条件。当然永远不要直接throw Exception

未受检的异常最好也建立文档

如果一个类中许多方法都出于同样的原因而抛出同一个异常，那么再该类的文档注释对异常建立文档这是可以接受的

为了更好的处理异常，最好再抛出的一场中包含一些细节

不要捕获异常但是不做任何的处理，最起码进行个最简单的打印操作 e.printStackTrace();

#### 10 类和接口

**使类和成员的可访问性最小化**

设计良好的组件要看对外部组件而言它是否很好的隐藏了内部的数据和实现的细节，模块间通过API联系，这被称为隐藏（information hiding）或者封装（encapsulation）

信息隐藏可以实现模块之间的解耦，模块之间可以独立的开发测试和维护，一个模块的问题不会影响到其他模块的性能。。总之要尽可能使每个类或者成员不被外界访问

Java提供了很多机制来协助信息隐藏

- private 只有声明该成员的顶层类内部才能访问
- package-private 声明该成员的包内部任何类都可以访问这个成员。
- protected 声明该成员的类的子类和包内部的任何类都能访问这个成员
- public 任何地方都可以访问

2 和3的最大的区别在于   2是实现的一部分  3是公共API的一部分

对于顶层的类和接口只有public 和 package-private。当然尽可能做成包级私有的

如果一个包级私有的顶层类或者接口只是在某一个类的内部被使用，那么就应该考虑将使它称为唯一使用他那个类的私有嵌套类。

在不确定的时候尽可能降低可访问性

在重写父类的方法时，是不能提高访问级别的。接口的成员是public，那么实现类也只能呢是public

不要为了方便测试来，提升成员的可访问性

**要在公有类而非公有域中使用访问方法**

全部使用public是不安全的，可以使用get/set方法来代替

如果类可以在他的包之外被访问，那么则需要提供访问方法

**使可变性最小化**

不可变类是指他的实例不能被修改，每个实例包含的信息必须在创建时就指定，并且在整个生命周期内不可变。有以下几个好处  (String  Integer  BigTnteger BigDecimal)

天生就是线程安全的，可以自由共享等等更加易于设计实现和使用,不需要进行防御性的拷贝

可变类可能会出现不一致的情况（[Bloch4 16](chrome-extension://cdonnmffkdaoajfknoeeecmchibpmkmg/assets/pdf/web/viewer.html?file=http%3A%2F%2F10.82.59.88%3A8080%2Faoot2020%2Fweek7%2FBloch4.pdf)）

使类称为不可变，需要遵循以下的原则

1 不要提供任何会修改对象状态的方法

2 声明所有的域都是final和private

3 不允许子类重写方法（保证类不会被扩展）

4 如果实例域包含对可变对象的引用，则不允许这些对象被更改（不要提供方法，也不要提供对象的引用）

缺点是：对于每一个不同的值都需要一个单独的对象

在并发应用程序中使用可变类应该非常小心，不可变对象本质上是线程安全的，他们不要求同步，多个线程并发访问不可变的对象时，并不会遭到破坏

String是不可变的，所以提供了（StringBuffer已经弃用 ）改用StringBuilder

**复合优先于继承** 仅针对实现继承时存在的问题  ，接口的继承并不存在此类的问题

继承在包内部使用是安全的，但是跨包是非常危险的

**继承是打破了封装的**：换句话说，子类依赖超类中特定功能的实现细节，超类的实现有可能会随着发行版本的不同而有所变化，那么子类可能受到破坏 eg书中的例子在继承HashSet并实现了addALL导致在添加元素时可能会出现重复添加。因为addAll方法是在add方法上实现的。在利用super.addALll方法时，调用了HashSet的adAll，而HashSet的addAll方法会调用add方法，再次把每个元素都添加一遍

重写方法可能会出现很多的威胁，可能会破坏超类的不可变性，也可能会破坏子类的不可变性

**复合（Composition）**解决了所有的问题，不扩展现有的类，而是在新类中增加一个私有域，它引用现有类的一个实例，新的类的每一个实例方法都可以调用被包含的现有类实例中对应的方法，并返回他的结果，这被称为**转发**（forwarding），比如书上的例子通过Set接口，因为Set接口保存了HashSet类的功能特性

![QQ图片20201114102343](C:\Users\YSH\Pictures\md的图片\QQ图片20201114102343.png)

Java中有很多地方违反了，比如stack并不是vector,所以栈不应该是扩展向量的。

**要么设计继承并提供说明文档，要么禁止继承**

该类的文档必须精确的描述覆盖每个方法带来的影响，换句话说，该类必须有文档说明它可覆盖（OverRide）的方法的自用性（self-use）

接口的设计是很重要的，如果接口设计的很糟糕，那么它的子类会很难受，并且没办法做出修改。

需要编写子类来测试为继承而设计的类（这也是唯一的测试方法），来判断某个方法是否应该设计为protected，通常三个子类的测试就足够了

**构造函数不能调用可重写的方法** 可能会出现输出不同步或者抛出异常（Block4 33）

![img](file:///C:\Users\YSH\Documents\Tencent Files\1028509048\Image\C2C\MOL@E5Q_W@QD3V[TV9R[`8B.png)

在上面的例子中，构造方法调用了可覆盖的函数m（）

那么我执行`Sub s = new Sub();`

Sub()的构造函数中发生的第一件事是调用了Super()的构造函数，但是Super()中对m()的调用被覆盖，但是data变量此时还未初始化。并且Super类中的m()从未被初始化

在为了继承而设计类的时候，Cloneable（克隆）和Serializable（序列化）接口出现了特殊的困难。因为这两个方法在行为上非常类似于构造器，所以类似的限制规则也是适用的

为了继承而设计类，对这个类会有一些实质性的限制

这个问题的最佳解决方案时，对于那些并非为了安全地进行子类化而设计和编写文档的类，要禁止子类化。

**接口优于抽象类**

由于java的单继承原则，使用抽象类作为类型定义受到了限制。但是现有的类很容易被更新以实现新的接口

接口是定义mixin(混合类型)的理想选择  比如说Comparable是一个mixin接口

接口允许构造非层次结构的类型框架

但是因为接口不能包括方法，所以有时候会比较难用

当然结合接口和抽象类的优点进行设计，对接口提供一个抽象的骨架实现（skeletal implementation）  通常被称为抽象接口（AbstractInterface） 

 AbstractCollection AbstractSet AbstractList等等,这些骨架类基本完美的实现了这些接口的所有功能，使用起来非常方便。

**类层次优于标签类**

标签类有许多缺点，充斥着很多样板代码，包括枚举声明、标签域及条件语句，标签过于冗长、容易出错、并且效率低下

例子中的shape类中，增加一个新的shape是很难的，将他拆解为父类子类就会见到那很多  定义一个abstract class Shape  只有一个抽象方法area()

**静态成员类优于非静态成员类**

嵌套类：nested classes 定义在一个类的内部的类，它存在的目的应该只是为他的外围类（enclosing class）提供服务   他是编译器而不是虚拟机支持的一种现象

嵌套类有静态成员类  非静态成员类  匿名类和局部类 除了第一种其他的均为内部类

静态成员类和非静态成员类之间的唯一的区别是，静态成员类的声明中包含修饰符static.非静态成员类的每个实例都隐含地与一种外围类的一个外围实例相关联（enclosing instance）可能存在一些性能问题，有时也可能需要自己创建，所所以倾向于使用静态类

#### 11 设计模式的区分

 java8还有java9一些新版的特性 optional等

optional是在java8被引入的，Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。

Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。

Optional 类的引入很好的解决空指针异常。

 ![image-20201113093840534](C:\Users\YSH\AppData\Roaming\Typora\typora-user-images\image-20201113093840534.png)



 ![image-20201113093847792](C:\Users\YSH\AppData\Roaming\Typora\typora-user-images\image-20201113093847792.png)

Java9引入了module,其实就是一组包，可以在模块声明中显示的导出某些包，通常位于module-info.java这个包中

![img](file:///C:\Users\YSH\Documents\Tencent Files\1028509048\Image\C2C\~FP~79NQ9~}{PR62J4S~VYO.png)