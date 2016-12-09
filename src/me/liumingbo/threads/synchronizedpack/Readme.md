# 注意事项
1. 当一个线程正在访问一个对象的`synchronized`方法，那么其他线程不能访问该对象的其他`synchronized`方法。这个原因很简单，因为一个对象只有一把锁，当一个线程获取了该对象的锁之后，其他线程无法获取该对象的锁，所以无法访问该对象的其他`synchronized`方法；
2. 当一个线程正在访问一个对象的`synchronized`方法，那么其他线程能访问该对象的非`synchronized`方法。这个原因很简单，访问非`synchronized`方法不需要获得该对象的锁，假如一个方法没用`synchronized`关键字修饰，说明它不会使用到临界资源，那么其他线程是可以访问这个方法的；
3. 如果一个`线程A`需要访问`对象object1`的`synchronized`方法`fun1`，另外一个`线程B`需要访问`对象object2`的`synchronized`方法`fun1`，即使`object1`和`object2`是同一类型），也不会产生线程安全问题，因为他们访问的是不同的对象，所以不存在互斥问题；
4. 对于`synchronized方法`或者`synchronized代码块`，当出现异常时，JVM会自动释放当前线程占用的锁，因此不会由于异常导致出现死锁现象。