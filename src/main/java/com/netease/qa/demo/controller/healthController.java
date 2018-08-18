package com.netease.qa.demo.controller;

import com.netease.qa.demo.constant.ProjectContant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/health")
public class healthController {

	private static boolean serverStatus = true;

	/**
	 * 服务启动完成可用检查接口(如果接入NDP会用到服务是否启动完成判断接口)
	 *
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public void serverCheck(HttpServletResponse response) throws IOException {
		write(response, true);
	}

	/**
	 * 健康检查接口
	 *
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public void healthCheck(HttpServletResponse response) throws IOException {
		response.setStatus(serverStatus ? HttpStatus.OK.value() : HttpStatus.INTERNAL_SERVER_ERROR.value());
		write(response, serverStatus);
	}

	/**
	 * 系统上线前调用该接口下线,HA移除该服务器的代理流量，然后上线，上线默认status=true，等有请求到了再继续部署下一个机器
	 *
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/offline", method = RequestMethod.GET)
	public void serverOffline(HttpServletResponse response) throws IOException {
		serverStatus = false;
		write(response, serverStatus);
	}

	/**
	 * Active system status
	 *
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/online", method = RequestMethod.GET)
	public void serverOnline(HttpServletResponse response) throws IOException {
		serverStatus = true;
		write(response, serverStatus);
	}

	/**
	 * 封装健康检查返回值
	 *
	 * @param serverStatus
	 *            服务器状态
	 * @param response
	 * @throws IOException
	 */
	private void write(HttpServletResponse response, boolean serverStatus) throws IOException {
		Map<String, Object> statusMap = new HashMap<String, Object>();
		statusMap.put("status", serverStatus);
		statusMap.put("timestamp", System.currentTimeMillis());
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(JSONObject.fromObject(statusMap));
		response.setCharacterEncoding(ProjectContant.DEFAULT_ENCODING);
		response.getWriter().write(jsonArray.toString());
		response.getWriter().flush();
	}


}
