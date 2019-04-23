package com.qhit.produceFault.pojo;


/**
* Created by GeneratorCode on 2019/04/09
*/ 

public class ProduceFault { 
    private Integer faultId;    //主键故障id 
    private Integer devid;    //设备名称 
    private String cause;    //故障原因 
    private String faultuser;    //报告人 
    private Integer faulttime;    //故障时间(分钟)

    private String devname;

    public String getDevname() {
        return devname;
    }

    public void setDevname(String devname) {
        this.devname = devname;
    }

    public Integer getFaultId() {
        return faultId;
    }

    public void setFaultId(Integer faultId) { 
        this.faultId = faultId;
    } 

    public Integer getDevid() { 
        return devid;
    }

    public void setDevid(Integer devid) { 
        this.devid = devid;
    } 

    public String getCause() { 
        return cause;
    }

    public void setCause(String cause) { 
        this.cause = cause;
    }
    public String getFaultuser() { 
        return faultuser;
    }

    public void setFaultuser(String faultuser) { 
        this.faultuser = faultuser;
    }
    public Integer getFaulttime() { 
        return faulttime;
    }

    public void setFaulttime(Integer faulttime) { 
        this.faulttime = faulttime;
    } 


 }