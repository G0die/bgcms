package edu.bgcms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Spring boot的CommandLineRunner接口主要用于实现在应用初始化后，去执行一段代码块逻辑，这段初始化代码在整个应用生命周期内只会执行一次。
 */
@Component
public class Talk implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("我有话说....................2");
    }
}
