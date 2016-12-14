package org.lf.yydp.etl.db.pojo;

import java.util.Date;

public class FilmInfo {
    private Integer id;

    private Integer fId;

    private String fName;

    private String fType;

    private Integer fDuration;

    private Date fOntime;

    private String fDirector;

    private String fCountry;

    private String fActor;

    private byte[] fSummary;

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

    public Integer getfDuration() {
        return fDuration;
    }

    public void setfDuration(Integer fDuration) {
        this.fDuration = fDuration;
    }

    public Date getfOntime() {
        return fOntime;
    }

    public void setfOntime(Date fOntime) {
        this.fOntime = fOntime;
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

    public String getfActor() {
        return fActor;
    }

    public void setfActor(String fActor) {
        this.fActor = fActor == null ? null : fActor.trim();
    }

    public byte[] getfSummary() {
        return fSummary;
    }

    public void setfSummary(byte[] fSummary) {
        this.fSummary = fSummary;
    }
}