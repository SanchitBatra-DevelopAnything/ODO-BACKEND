package com.odo.b2b.backend.ODO_B2B;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.odo.b2b.backend.ODO_B2B.mapper")
@SpringBootApplication
public class OdoB2BApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdoB2BApplication.class, args);
	}

}
