package edu.bgcms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "edu.bgcms.dao")
@SpringBootApplication
public class BgcmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgcmsApplication.class, args);
    }

}
