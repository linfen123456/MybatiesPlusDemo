package cn.kuaishang.mybatiesplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.kuaishang.mybatiesplus.mapper")
public class MybatiesPlusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatiesPlusDemoApplication.class, args);
    }

}
