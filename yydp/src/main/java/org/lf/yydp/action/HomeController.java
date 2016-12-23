package org.lf.yydp.action;

import org.lf.yydp.service.film.BuyTicketService;
import org.lf.yydp.service.model.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private BuyTicketService btService;
	
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
	
	@RequestMapping("getSeatsArray.do")
	@ResponseBody
	public Integer[] getSeatsArray (Integer plan_id) {
		return btService.getSeatsArray(plan_id);//?
	}
	
	@RequestMapping("getMovieInfo.do")
	@ResponseBody
	public MovieInfo getMovieInfo (Integer plan_id) {
		return btService.getMovieInfo(plan_id);//?
	}
	
	@RequestMapping("sentEmail.do")
	@ResponseBody
	public void sentEmail (String receiver) {
		btService.sendEmail(receiver);
	}
	
	@RequestMapping("onlinePayUI.do")
	public String onlinePayUI () {
		return "onlinePay";
	}
}
