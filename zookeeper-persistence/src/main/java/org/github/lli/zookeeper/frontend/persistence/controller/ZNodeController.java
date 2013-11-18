package org.github.lli.zookeeper.frontend.persistence.controller;

import java.util.List;

import org.github.lli.zookeeper.frontend.persistence.model.RESTFulServiceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author startupleo2013
 * 
 */
@Controller
public class ZNodeController {

	@RequestMapping(value = "/query/all", method = RequestMethod.GET)
	@ResponseBody
	public void getAll() {
		try {
			List<String> nodes = RESTFulServiceUtils.getCuratorFramework()
					.getChildren().forPath("/");
			for(String node : nodes)
				System.out.println(node);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
