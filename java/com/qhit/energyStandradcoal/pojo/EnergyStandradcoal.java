package com.qhit.energyStandradcoal.pojo;


/** 
* Created by GeneratorCode on 2019/04/10
*/ 

public class EnergyStandradcoal { 
    private Integer sid;    //主键 
    private String energetype;    //能源类别 
    private Float ratio;    //系数 

    public Integer getSid() { 
        return sid;
    }

    public void setSid(Integer sid) { 
        this.sid = sid;
    } 

    public String getEnergetype() { 
        return energetype;
    }

    public void setEnergetype(String energetype) { 
        this.energetype = energetype;
    }
    public Float getRatio() { 
        return ratio;
    }

    public void setRatio(Float ratio) { 
        this.ratio = ratio;
    }


 }