package org.yumi;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySlf4j {
    public void doSomething() {
        // 直接使用 log 记录日志
        log.info("This is an info message.");
        log.error("This is an error message.", new Exception("Something went wrong!"));
    }

    public static void main(String[] args) {
        MySlf4j mySlf4j = new MySlf4j();
        mySlf4j.doSomething();
    }
}
