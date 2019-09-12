# 如何用面向对象编程思想来解决葫芦娃站队问题

171860537 罗沁禹



## 问题理解

此问题是将七个葫芦娃分别按排行进行冒泡排序和按颜色进行二分排序，所以每个葫芦娃都具有排行和颜色两种属性，因此设计一个葫芦娃类，类中有两个字段，分别为排行和颜色。每个葫芦娃都为该类的一个对象，每个对象分别有自己的排行和颜色。为了进行排序，该类中还应该有两种方法，分别是根据排行得到排序权值的大小和根据颜色得到排序权值的大小。至此，就可以分别根据排行和颜色解决站队问题。



## 具体实现

```java
class HuLuWa {
    public String rank;//排行
    public String color;//颜色
    HuLuWa(String r, String c)//构造函数 
    public int getNumberByRank()//得到排行的值
    public int getNumberByColor()//得到颜色的值
    public void reportChange(int prev, int now)//位置改变时报告交换动作
}
```

rank和color字段分别存储排行和颜色的值，getNumberByRank函数返回给调用者该葫芦娃的排行对应的值，如老大返回1，老七返回7，便于调用者进行排序。getNumberByColor函数与getNumberByRank函数类似，返回给调用者该葫芦娃颜色对应的值，如红色返回1，紫色返回7。reportChange函数用于每次交换位置后报告交换动作，参数prev表示交换之前的位置，now表示交换之后的位置，该函数根据传入参数的值进行输出，报告交换动作。



main函数位于Sort类中。main函数中首先创建七个葫芦娃对象，每个对象分别调用构造函数初始化对应的排行字段和颜色字段。

```java
	int n = 7;
    HuLuWa[] list = new HuLuWa[n];
    HuLuWa[] h = new HuLuWa[n];
    h[0]=new HuLuWa("老大","红色");
    h[1]=new HuLuWa("老二","橙色");
    h[2]=new HuLuWa("老三","黄色");
    h[3]=new HuLuWa("老四","绿色");
    h[4]=new HuLuWa("老五","青色");
    h[5]=new HuLuWa("老六","蓝色");
    h[6]=new HuLuWa("老七","紫色");
```

然后调用随机数模拟葫芦娃随机站队，站队模拟完毕后分别用冒泡排序按排行站队和二分排序按颜色站队，排序过程中每交换一次便调用被交换对象的reportChange函数报告交换动作，排序完毕后一次输出每个对象的排行和颜色。

总的来说，解决本问题的面向对象思想便是设计一个葫芦娃类，类中包含排行和颜色字段，每个葫芦娃都是该类的一个对象，对这7个对象进行操作。