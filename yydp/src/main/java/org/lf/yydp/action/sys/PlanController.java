package org.lf.yydp.action.sys;

import org.lf.yydp.service.sys.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys")
public class PlanController {
	@Autowired
	private PlanService scheduleService;

	@RequestMapping("loadSchedule.do")
	@ResponseBody
	public String load(){
		scheduleService.insertScedule();
		return "success";
	}
}
