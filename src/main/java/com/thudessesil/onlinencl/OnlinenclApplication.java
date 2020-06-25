package com.thudessesil.onlinencl;

import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.thudessesil.onlinencl.ModelFileManager.mapper")
public class OnlinenclApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OnlinenclApplication.class, args);
	}

	// test connection
	@ApiOperation(value = "test connection", notes = "a hello world to test connection")
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}