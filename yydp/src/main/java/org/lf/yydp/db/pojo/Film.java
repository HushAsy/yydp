package org.lf.yydp.db.pojo;

public class Film {
    private Integer id;

    private String href;

    private String img;

    private String status;

    private String localimgpath;

    private String picdownloadstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLocalimgpath() {
        return localimgpath;
    }

    public void setLocalimgpath(String localimgpath) {
        this.localimgpath = localimgpath == null ? null : localimgpath.trim();
    }

    public String getPicdownloadstatus() {
        return picdownloadstatus;
    }

    public void setPicdownloadstatus(String picdownloadstatus) {
        this.picdownloadstatus = picdownloadstatus == null ? null : picdownloadstatus.trim();
    }
}