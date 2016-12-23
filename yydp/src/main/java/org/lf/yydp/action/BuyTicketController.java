package org.lf.yydp.action;

import java.util.List;

import org.lf.yydp.service.film.BuyTicketService;
import org.lf.yydp.service.model.TicketItemDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("buy")
public class BuyTicketController {
	@Autowired
	private BuyTicketService ticketService;
	
	@RequestMapping("buyTicketUI.do")
	public String filmQueryUI(Integer plan_id, Model m){
		m.addAttribute("plan", ticketService.getPlanById(plan_id));
		return "jsp/buyticket/buyTicket";
	}
	
	@RequestMapping("ticketItem.do")
	public String ticketItem(Integer f_id, Model m){
		m.addAttribute("f_id", f_id);
		return "jsp/buyticket/ticketItem";
	}
	
	@RequestMapping("ticketItemData.do")
	@ResponseBody
	public List<TicketItemDataModel>  getModelList(Integer f_id){
		return ticketService.getPlanList(f_id);
	}
}

