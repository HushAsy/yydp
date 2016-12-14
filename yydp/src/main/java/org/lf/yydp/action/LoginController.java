package org.lf.yydp.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
	@RequestMapping("test.do")
	public String getInfo(){
		System.out.println("success!!!");
		return "success";
	}
}
