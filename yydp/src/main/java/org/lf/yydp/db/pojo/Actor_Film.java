package org.lf.yydp.db.pojo;

public class Actor_Film {
    private Integer id;

    private String actorname;

    private Integer fId;

    private String role;

    private String picture;

    private String localpathimg;

    private String picdownloadstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActorname() {
        return actorname;
    }

    public void setActorname(String actorname) {
        this.actorname = actorname == null ? null : actorname.trim();
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getLocalpathimg() {
        return localpathimg;
    }

    public void setLocalpathimg(String localpathimg) {
        this.localpathimg = localpathimg == null ? null : localpathimg.trim();
    }

    public String getPicdownloadstatus() {
        return picdownloadstatus;
    }

    public void setPicdownloadstatus(String picdownloadstatus) {
        this.picdownloadstatus = picdownloadstatus == null ? null : picdownloadstatus.trim();
    }
}