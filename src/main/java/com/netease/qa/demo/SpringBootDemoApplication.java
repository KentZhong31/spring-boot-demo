package com.netease.qa.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netease.qa.demo.constant.ProjectContant;


@RestController
@SpringBootApplication
public class SpringBootDemoApplication {
	@Value(value = "${env.name}")
	private String envName ;
	@Value(value = "${server.port}")
	private int serverPort;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@RequestMapping(value = "/verison" , produces = "text/plain;charset=UTF-8")
	String showVersion(){
		return ProjectContant.MY_VERSION;
	}

	@RequestMapping(value = "/showCurrentEnv" , produces = "text/plain;charset=UTF-8")
	String showCurrentEnv(){
		return "The currently env is : " + envName + " ,and the server port is : " + String.valueOf(serverPort);
	}
}
