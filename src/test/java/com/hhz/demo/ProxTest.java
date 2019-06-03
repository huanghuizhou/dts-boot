package com.hhz.demo;

import java.lang.reflect.Proxy;

public class ProxTest {
    // 接收一个目标对象
    private Object target;


    public ProxTest(Object target) {
        this.target = target;
    }

    public static void main(String[] args) {
        Hhz a = new HhzImpl();
        Object proxyInstance = new ProxTest(a).getProxyInstance();
        Hhz b = (Hhz) proxyInstance;
        b.say();
        b.say();
    }

    // 返回对目标对象(target)代理后的对象(proxy)
    public Object getProxyInstance() {
        // 执行代理对象方法时候触发
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),  // 目标对象使用的类加载器
                target.getClass().getInterfaces(),   // 目标对象实现的所有接口
                (proxy1, method, args) -> {

                    // 获取当前执行的方法的方法名
                    String methodName = method.getName();
                    // 方法返回值
                    Object result = null;
                    if ("find".equals(methodName)) {
                        // 直接调用目标对象方法
                        result = method.invoke(target, args);
                    } else {
                        System.out.println("开启事务...");
                        // 执行目标对象方法
                        result = method.invoke(target, args);
                        System.out.println("提交事务...");
                    }
                    return result;
                }
        );
        return proxy;
    }

}
