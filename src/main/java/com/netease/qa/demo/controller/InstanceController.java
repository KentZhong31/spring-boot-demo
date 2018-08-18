package com.netease.qa.demo.controller;

import com.netease.qa.demo.bean.DemoInstanceBean;
import com.netease.qa.demo.constant.ProjectContant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class InstanceController {
	@Autowired
	DemoInstanceBean demoInstanceBean;
	@RequestMapping(value = "/instance" , produces = "text/plain;charset=UTF-8")
	String showVersion(){
		return "The instance name is: " + demoInstanceBean.getInstanceName() + " and the instance owner is: "
				+ demoInstanceBean.getInstanceOwner();
	}

}
