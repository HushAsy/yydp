package org.lf.yydp.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("filmQuery")
public class filmQuery {
	
	@RequestMapping("filmQueryUI")
	public String filmQueryUI(){
		return null;
	}
}
