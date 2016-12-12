通常来说，使用volatile必须具备以下2个条件：
1. 对变量的写操作不依赖于当前值；
2. 该变量没有包含在具有其他变量的不变式中。

上面的2个条件需要保证操作是原子性操作，才能保证使用volatile关键字的程序在并发时能够正确执行。

常见场景如下：
* 状态标记量
```java
volatile boolean flag = false;
 
while(!flag){
    doSomething();
}
 
public void setFlag() {
    flag = true;
}
```

```java
volatile boolean inited = false;
//线程1:
context = loadContext();  
inited = true;

//线程2:
while(!inited ){
sleep()
}
doSomethingwithconfig(context);
```

* double check
```java
class Singleton{
    private volatile static Singleton instance = null;
     
    private Singleton() {
         
    }
     
    public static Singleton getInstance() {
        if(instance==null) {
            synchronized (Singleton.class) {
                if(instance==null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}
```