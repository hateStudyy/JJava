package org.yumi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyReflection {
    public static void main(String[] args) {
        try {
            // 1. 获取 Class 对象（方式一：通过类名）
            Class<?> clazz = Class.forName("org.yumi.MyClass");

            // 2. 创建实例（调用无参构造函数）
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // 3. 获取并调用方法
            Method sayHelloMethod = clazz.getMethod("sayHello");
            sayHelloMethod.invoke(instance); // 调用 sayHello()

            // 4. 获取并设置字段值
            Field messageField = clazz.getDeclaredField("message");
            messageField.setAccessible(true); // 允许访问私有字段
            messageField.set(instance, "Hello from Reflection!");

            // 5. 再次调用方法，验证字段是否修改成功
            sayHelloMethod.invoke(instance);

            // 6. 调用带参数的方法
            Method greetMethod = clazz.getMethod("greet", String.class);
            greetMethod.invoke(instance, "Alice");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
