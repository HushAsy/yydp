package org.lf.yydp.service.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MovieInfo {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private String localImgPath;//图片URL
	
	private String f_name;//片名
	
	private String f_type;//影片类型
	
	private String f_country;//版本
	
	private String f_ontime;
	
	private Double money;
	
	private Date play_time;
	
	private String playTime;
	
	private Integer number;
	
	private String f_duration;
	
	private Integer rest;

	public String getLocalImgPath() {
		return localImgPath;
	}

	public void setLocalImgPath(String localImgPath) {
		this.localImgPath = localImgPath;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_type() {
		return f_type;
	}

	public void setF_type(String f_type) {
		this.f_type = f_type;
	}

	public String getF_country() {
		return f_country;
	}

	public void setF_country(String f_country) {
		this.f_country = f_country;
	}

	public String getF_ontime() {
		return f_ontime;
	}

	public void setF_ontime(String f_ontime) {
		this.f_ontime = f_ontime;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Date getPlay_time() {
		return play_time;
	}

	public void setPlay_time(Date play_time) {
		this.play_time = play_time;
		this.playTime = convertDateToString(this.play_time);
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getF_duration() {
		return f_duration;
	}

	public void setF_duration(String f_duration) {
		this.f_duration = f_duration;
	}
	
	public Integer getRest() {
		return rest;
	}

	public void setRest(Integer rest) {
		this.rest = rest;
	}

	private String convertDateToString(Date date){
		return sdf.format(date);
	}
}
