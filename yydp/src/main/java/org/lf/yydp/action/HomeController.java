package org.lf.yydp.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
	@RequestMapping("left.do")
	public String left(){
		return "home_left";
	}
	
	@RequestMapping("top.do")
	public String top(){
		return "home_top";
	}
	
	@RequestMapping("center.do")
	public String center(){
		return "home_center";
	}
}
