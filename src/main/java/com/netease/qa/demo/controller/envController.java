package com.netease.qa.demo.controller;

import com.netease.qa.demo.bean.DemoInstanceBean;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController

public class envController {
	@Autowired
	DemoInstanceBean demoInstanceBean;
	@RequestMapping(value = "/env" , produces = "text/plain;charset=UTF-8")
	String showEnv(){
		Map<String, String> envMap = System.getenv();
		JSONObject envJson = JSONObject.fromObject(envMap);
		return "The env: \n" + envJson.toString();
	}

}
