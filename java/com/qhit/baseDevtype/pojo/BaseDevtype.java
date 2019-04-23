package com.qhit.baseDevtype.pojo;


/** 
* Created by GeneratorCode on 2019/04/02
*/ 

public class BaseDevtype { 
    private Integer typeid;    //类别ID 
    private String typename;    //类别名称 

    public Integer getTypeid() { 
        return typeid;
    }

    public void setTypeid(Integer typeid) { 
        this.typeid = typeid;
    } 

    public String getTypename() { 
        return typename;
    }

    public void setTypename(String typename) { 
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "BaseDevtype{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }
}