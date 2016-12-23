package org.lf.yydp.service.model;

public class MovieInfo {
	
	private String localImgPath;//图片URL
	
	private String f_name;//片名
	
	private String f_type;//影片类型
	
	private String f_country;//版本
	
	private String f_ontime;
	
	private Double money;

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
	
}
