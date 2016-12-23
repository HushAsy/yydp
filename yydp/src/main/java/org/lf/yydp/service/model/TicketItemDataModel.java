package org.lf.yydp.service.model;

/**
 * 用户点击购票弹出的当前电影档期条目
 * 
 * @author Administrator
 */
public class TicketItemDataModel {
	private String play_time;
	private String ph_id;
	private String plan_id;
	
	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public String getPlay_time() {
		return play_time;
	}

	public void setPlay_time(String play_time) {
		this.play_time = play_time;
	}

	public String getPh_id() {
		return ph_id;
	}

	public void setPh_id(String ph_id) {
		this.ph_id = ph_id;
	}

}
