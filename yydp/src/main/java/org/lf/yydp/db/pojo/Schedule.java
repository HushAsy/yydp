package org.lf.yydp.db.pojo;

import java.util.Date;

public class Schedule {
    private Integer id;

    private Integer fId;

    private Date scheTime;

    private Double money;

    private Date playTime;

    private String status;

    private String isstart;

    private Integer phId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Date getScheTime() {
        return scheTime;
    }

    public void setScheTime(Date scheTime) {
        this.scheTime = scheTime;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsstart() {
        return isstart;
    }

    public void setIsstart(String isstart) {
        this.isstart = isstart == null ? null : isstart.trim();
    }

    public Integer getPhId() {
        return phId;
    }

    public void setPhId(Integer phId) {
        this.phId = phId;
    }
}