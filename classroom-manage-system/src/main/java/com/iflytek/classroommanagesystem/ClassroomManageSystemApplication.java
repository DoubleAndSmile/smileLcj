package com.iflytek.classroommanagesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iflytek.classroommanagesystem.mapper")
public class ClassroomManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassroomManageSystemApplication.class, args);
    }

}
