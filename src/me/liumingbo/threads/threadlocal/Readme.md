## ThreadLocal要点

* 实际的通过ThreadLocal创建的副本是存储在每个线程自己的threadLocals中的；
* 为何threadLocals的类型ThreadLocalMap的键值为ThreadLocal对象，因为每个线程中可有多个threadLocal变量，就像上面代码中的longLocal和stringLocal；
* 在进行get之前，必须先set，否则会报空指针异常，如果想在get之前不需要调用set就能正常访问的话，必须重写initialValue()方法。

## ThreadLocal的应用场景
### 1. 多线程数据库链接
```java
private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
public Connection initialValue() {
    return DriverManager.getConnection(DB_URL);
}
};
 
public static Connection getConnection() {
return connectionHolder.get();
}
```

### 2. Session管理
```java
private static final ThreadLocal threadSession = new ThreadLocal();
 
public static Session getSession() throws InfrastructureException {
    Session s = (Session) threadSession.get();
    try {
        if (s == null) {
            s = getSessionFactory().openSession();
            threadSession.set(s);
        }
    } catch (HibernateException ex) {
        throw new InfrastructureException(ex);
    }
    return s;
}
```
