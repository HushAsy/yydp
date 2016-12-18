package org.lf.yydp.db.pojo;

public class FilmInfo {
    private Integer id;

    private Integer fId;

    private String fName;

    private String fType;

    private String fDuration;

    private String fOntime;

    private String fDirector;

    private String fCountry;

    private String fSummary;

    private String fActor;

    private String bigimage;

    private String localbigimage;

    private String picdownloadstatus;

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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType == null ? null : fType.trim();
    }

    public String getfDuration() {
        return fDuration;
    }

    public void setfDuration(String fDuration) {
        this.fDuration = fDuration == null ? null : fDuration.trim();
    }

    public String getfOntime() {
        return fOntime;
    }

    public void setfOntime(String fOntime) {
        this.fOntime = fOntime == null ? null : fOntime.trim();
    }

    public String getfDirector() {
        return fDirector;
    }

    public void setfDirector(String fDirector) {
        this.fDirector = fDirector == null ? null : fDirector.trim();
    }

    public String getfCountry() {
        return fCountry;
    }

    public void setfCountry(String fCountry) {
        this.fCountry = fCountry == null ? null : fCountry.trim();
    }

    public String getfSummary() {
        return fSummary;
    }

    public void setfSummary(String fSummary) {
        this.fSummary = fSummary == null ? null : fSummary.trim();
    }

    public String getfActor() {
        return fActor;
    }

    public void setfActor(String fActor) {
        this.fActor = fActor == null ? null : fActor.trim();
    }

    public String getBigimage() {
        return bigimage;
    }

    public void setBigimage(String bigimage) {
        this.bigimage = bigimage == null ? null : bigimage.trim();
    }

    public String getLocalbigimage() {
        return localbigimage;
    }

    public void setLocalbigimage(String localbigimage) {
        this.localbigimage = localbigimage == null ? null : localbigimage.trim();
    }

    public String getPicdownloadstatus() {
        return picdownloadstatus;
    }

    public void setPicdownloadstatus(String picdownloadstatus) {
        this.picdownloadstatus = picdownloadstatus == null ? null : picdownloadstatus.trim();
    }
}